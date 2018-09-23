package com.mwronski.sample.payments.model

data class SponsorParty(
        val accountNumber: AccountNumber,
        val bankId: BankId,
        val bankIdCode: BankIdCode
)