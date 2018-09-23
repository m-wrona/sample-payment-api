package com.mwronski.sample.payments.model

data class BeneficiaryParty(
        val accountName: String,
        val accountNumber: AccountNumber,
        val accountNumberCode: AccountNumberCode,
        val accountType: Int,
        val address: String,
        val bankId: BankId,
        val bankIdCode: BankIdCode,
        val name: String
)