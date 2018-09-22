package com.mwronski.sample.payments.http

import com.mwronski.sample.payments.model.Data
import com.mwronski.sample.payments.service.PaymentsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import org.springframework.web.bind.annotation.GetMapping
import reactor.core.publisher.Flux
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.RequestBody
import javax.validation.Valid
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.PostMapping

@RestController
@RequestMapping(PaymentsResourceV1.BASE_URL)
class PaymentsResourceV1 {

    companion object {

        const val BASE_URL = "/v1/payments"

    }

    private val repository: PaymentsRepository

    @Autowired
    constructor(repository: PaymentsRepository) {
        this.repository = repository
    }

    @GetMapping("/")
    fun getAll(): Flux<Data> = repository.findAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable(value = "id") id: String): Mono<ResponseEntity<Data>> =
            repository.findById(id)
                    .map({ d -> ResponseEntity.ok(d) })
                    .defaultIfEmpty(ResponseEntity.notFound().build())

    @PostMapping("/")
    fun create(@Valid @RequestBody data: Data): Mono<ResponseEntity<Void>> =
            repository.save(data)
                    .map { savedData -> noContentResponse(BASE_URL, savedData.id) }

    @PutMapping("/{id}")
    fun update(
            @PathVariable(value = "id") id: String,
            @Valid @RequestBody data: Data
    ): Mono<ResponseEntity<Data>> =
            repository.findById(id)
                    .flatMap { _ -> repository.save(data) }
                    .map { updatedData -> ResponseEntity.ok(updatedData) }
                    .defaultIfEmpty(ResponseEntity.notFound().build())

    @DeleteMapping("/{id}")
    fun delete(@PathVariable(value = "id") id: String): Mono<ResponseEntity<Void>> =
            repository.findById(id)
                    .flatMap { dbData ->
                        repository.delete(dbData)
                                .then(Mono.just(ResponseEntity<Void>(HttpStatus.OK)))
                    }
                    .defaultIfEmpty(ResponseEntity.notFound().build())

}