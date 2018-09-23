package com.mwronski.sample.payments.model

data class DebtorParty(
        val accountName: String,
        val accountNumber: AccountNumber,
        val accountNumberCode: AccountNumberCode,
        val address: String,
        val bankId: BankId,
        val bankIdCode: BankIdCode,
        val name: String
)