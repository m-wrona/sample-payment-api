package com.mwronski.sample.payments.http

import org.springframework.http.ResponseEntity

import org.springframework.web.util.UriComponentsBuilder

internal fun noContentResponse(baseUrl: String, id: String): ResponseEntity<Void> =
        ResponseEntity
                .noContent()
                .location(UriComponentsBuilder.fromPath("$baseUrl/$id").build().toUri())
                .build()
