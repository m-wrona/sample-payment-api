package com.mwronski.sample.payments.test

import com.mwronski.sample.payments.http.NewDataRequest
import com.mwronski.sample.payments.http.PaymentsResourceV1
import com.mwronski.sample.payments.model.Data
import com.mwronski.sample.payments.service.PaymentsRepository
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.reactive.server.WebTestClient
import org.junit.Assert
import org.springframework.http.MediaType
import reactor.core.publisher.Mono
import org.hamcrest.Matchers.`is`

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PaymentsApiIntegrationTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @Autowired
    lateinit var repository: PaymentsRepository

    @Test
    fun shouldAddValidPayment() {
        //GIVEN valid payment
        val payment = PaymentsTestData.newValidPayment()

        //WHEN payment is sent
        val resp = webTestClient.post().uri(PaymentsResourceV1.BASE_URL + "/")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .body(Mono.just(payment), NewDataRequest::class.java)
                .exchange()

        //THEN payment is saved
        resp.expectStatus().isCreated()
                .expectHeader().valueMatches("Location", PaymentsResourceV1.BASE_URL + "/.*")
                .expectBody().isEmpty()
    }

    @Test
    fun shouldNotAddInvalidPayment() {
        //GIVEN invalid payment
        val payment = PaymentsTestData.newInvalidPayment()

        //WHEN payment is sent
        val resp = webTestClient.post().uri(PaymentsResourceV1.BASE_URL + "/")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .body(Mono.just(payment), NewDataRequest::class.java)
                .exchange()

        //THEN payment is not saved
        //AND validation errors are verbose
        resp.expectStatus().isBadRequest()
        val respBody = resp.expectBody().returnResult().toString()
        Assert.assertTrue("Validation error for OrganizationId missing", respBody.contains("OrganizationId must be set"))
        Assert.assertTrue("Validation error for ID missing", respBody.contains("ID must be empty"))
    }

    @Test
    fun shouldUpdateExistingPaymentWithValidValues() {
        //GIVEN payment already exists
        val paymentV1 = PaymentsTestData.newValidPayment().toData()
        repository.save(paymentV1).block()

        //WHEN payment is updated with valid data
        val resp = webTestClient.put().uri(PaymentsResourceV1.BASE_URL + "/${paymentV1.id}")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .body(Mono.just(paymentV1.copy(organisationId = "new-organization-id")), Data::class.java)
                .exchange()

        //THEN data is changed
        resp.expectStatus().isNoContent()
        val paymentV2 = repository.findById(paymentV1.id).block()
        Assert.assertThat("Version not updated", paymentV2.version, `is`(1))
        Assert.assertThat("OrganizationId not updated", paymentV2.organisationId, `is`("new-organization-id"))
    }

    @Test
    fun shouldNotUpdateExistingPaymentWithInvalidValues() {
        //GIVEN payment already exists
        val paymentV1 = PaymentsTestData.newValidPayment().toData()
        repository.save(paymentV1).block()

        //WHEN payment is updated with invalid data
        val resp = webTestClient.put().uri(PaymentsResourceV1.BASE_URL + "/${paymentV1.id}")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .body(Mono.just(paymentV1.copy(organisationId = "")), Data::class.java)
                .exchange()

        //THEN data is not changed
        resp.expectStatus().isBadRequest()
        val respBody = resp.expectBody().returnResult().toString()
        Assert.assertTrue("Validation error for OrganizationId missing", respBody.contains("OrganizationId must be set"))
    }

    @Test
    fun shouldNotUpdateNonExistingPayment() {
        //GIVEN payment doesn't exists
        val nonExistingPayment = PaymentsTestData.newValidPayment().toData()

        //WHEN payment is updated with invalid data
        val resp = webTestClient.put().uri(PaymentsResourceV1.BASE_URL + "/${nonExistingPayment.id}")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .body(Mono.just(nonExistingPayment.copy(organisationId = "some-value")), Data::class.java)
                .exchange()

        //THEN data is not changed
        resp.expectStatus().isNotFound()
    }

    @Test
    fun shouldDeleteExistingPayment() {
        //GIVEN payment already exists
        val paymentV1 = PaymentsTestData.newValidPayment().toData()
        repository.save(paymentV1).block()

        //WHEN payment is deleted
        val resp = webTestClient.delete().uri(PaymentsResourceV1.BASE_URL + "/${paymentV1.id}")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()

        //THEN data is changed
        resp.expectStatus().isNoContent()
    }

    @Test
    fun shouldNotDeleteNonExistingPayment() {
        //GIVEN payment doesn't exists
        val nonExistingPayment = PaymentsTestData.newValidPayment().toData()

        //WHEN payment is deleted
        val resp = webTestClient.delete().uri(PaymentsResourceV1.BASE_URL + "/${nonExistingPayment.id}")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()

        //THEN data is not changed
        resp.expectStatus().isNotFound()
    }

    @Test
    fun shouldGetAllPayments() {
        //GIVEN payments defined
        val payment1 = PaymentsTestData.newValidPayment().toData()
        repository.save(payment1).block()
        val payment2 = PaymentsTestData.newValidPayment().toData()
        repository.save(payment2).block()

        //WHEN getting all payments
        val resp = webTestClient.get().uri(PaymentsResourceV1.BASE_URL + "/")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()

        //THEN data is returned
        resp.expectStatus().isOk()
                .expectBody()
                .jsonPath("$[0].id").isNotEmpty
                .jsonPath("$[1].id").isNotEmpty
    }

    @Test
    fun shouldGetChosenPayment() {
        //GIVEN payment defined
        val payment1 = PaymentsTestData.newValidPayment().toData()
        repository.save(payment1).block()

        //WHEN getting chosen payment
        val resp = webTestClient.get().uri(PaymentsResourceV1.BASE_URL + "/${payment1.id}")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()

        //THEN data is returned
        resp.expectStatus().isOk()
                .expectBody()
                .jsonPath("$.id").isEqualTo(payment1.id)
    }

    @Test
    fun shouldNotGetNonExistingPayment() {
        //GIVEN no payment defined

        //WHEN getting some payment
        val resp = webTestClient.get().uri(PaymentsResourceV1.BASE_URL + "/any-id")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()

        //THEN no data is returned
        resp.expectStatus().isNotFound()
    }

}