package com.mwronski.sample.payments.model

data class Fx(
        val contractReference: String,
        val exchangeRate: Double,
        val originalAmount: Double,
        val originalCurrency: Currency
)