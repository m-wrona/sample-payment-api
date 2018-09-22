package com.mwronski.sample.payments.model

data class Data(
        val type: String,
        val id: String,
        val version: Int,
        val organisation_id: String,
        val attributes: Attributes
)