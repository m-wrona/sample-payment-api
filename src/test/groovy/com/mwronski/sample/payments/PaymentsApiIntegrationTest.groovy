package com.mwronski.sample.payments

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import spock.lang.Specification

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PaymentsApiIntegrationTest extends Specification {

    def setup() {
    }

    @Test
    def "should add payment"() {
        given: "valid payment"
        String d = "a"
//        given: "payment has not been added"

        when: "new payment is sent"
        d+="2"

        then: "payment is saved"
        d == "a2"
    }

}
