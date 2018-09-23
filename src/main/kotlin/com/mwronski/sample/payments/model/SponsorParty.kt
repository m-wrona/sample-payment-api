package com.mwronski.sample.payments.model

import javax.validation.constraints.NotNull

data class SponsorParty(
        @field:NotNull(message = "AccountNumber must be set")
        val accountNumber: AccountNumber,
        @field:NotNull(message = "BankId must be set")
        val bankId: BankId,
        @field:NotNull(message = "BankIdCode must be set")
        val bankIdCode: BankIdCode
)