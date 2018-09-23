package com.mwronski.sample.payments.model

import javax.validation.constraints.NotNull

data class DebtorParty(
        @field:NotNull(message = "AccountName must be set")
        val accountName: String,
        @field:NotNull(message = "AccountNumber must be set")
        val accountNumber: AccountNumber,
        @field:NotNull(message = "AccountNumberCode must be set")
        val accountNumberCode: AccountNumberCode,
        @field:NotNull(message = "Address must be set")
        val address: String,
        @field:NotNull(message = "BankId must be set")
        val bankId: BankId,
        @field:NotNull(message = "BankIdCode must be set")
        val bankIdCode: BankIdCode,
        @field:NotNull(message = "Name must be set")
        val name: String
)