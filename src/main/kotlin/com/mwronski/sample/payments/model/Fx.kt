package com.mwronski.sample.payments.model

data class Fx(
        val contract_reference: String,
        val exchange_rate: String,
        val original_amount: String,
        val original_currency: String
)