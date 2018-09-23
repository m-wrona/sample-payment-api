package com.mwronski.sample.payments.model

import javax.validation.constraints.NotNull

data class Fx(
        @field:NotNull(message = "ContractReference must be set")
        val contractReference: String,
        @field:NotNull(message = "ExchangeRate must be set")
        val exchangeRate: Double,
        @field:NotNull(message = "OriginalAmount must be set")
        val originalAmount: Double,
        @field:NotNull(message = "OriginalCurrency must be set")
        val originalCurrency: Currency
)