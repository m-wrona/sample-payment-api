package com.mwronski.sample.payments.model

import javax.validation.constraints.NotNull

data class SenderCharge(
        @field:NotNull(message = "Amount must be set")
        val amount: Double,
        @field:NotNull(message = "Currency must be set")
        val currency: Currency
)