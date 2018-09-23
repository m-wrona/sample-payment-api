package com.mwronski.sample.payments.http

import org.springframework.http.ResponseEntity

import org.springframework.web.util.UriComponentsBuilder

internal fun createdResponse(baseUrl: String, id: String): ResponseEntity<Void> =
        ResponseEntity
                .created(UriComponentsBuilder.fromPath("$baseUrl/$id").build().toUri())
                .build()

internal fun noContentResponse(): ResponseEntity<Void> =
        ResponseEntity
                .noContent()
                .build()

internal fun <T> notFoundResponse(): ResponseEntity<T> =
        ResponseEntity
                .notFound()
                .build()
