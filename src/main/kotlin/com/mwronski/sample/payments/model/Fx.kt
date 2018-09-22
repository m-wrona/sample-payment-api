package com.mwronski.sample.payments.model

data class Fx(
        val contract_reference: String,
        val exchange_rate: Double,
        val original_amount: Double,
        val original_currency: Currency
)