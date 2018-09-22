package com.mwronski.sample.payments

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@SpringBootApplication
@EnableReactiveMongoRepositories
class PaymentsApiApplication

fun main(args: Array<String>) {
    runApplication<PaymentsApiApplication>(*args)
}
