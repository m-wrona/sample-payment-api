package com.mwronski.sample.payments.model

data class SponsorParty(
        val account_number: AccountNumber,
        val bank_id: BankId,
        val bank_id_code: BankIdCode
)