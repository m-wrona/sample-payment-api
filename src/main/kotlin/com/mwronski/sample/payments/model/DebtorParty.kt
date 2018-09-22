package com.mwronski.sample.payments.model

data class DebtorParty(
        val account_name: String,
        val account_number: AccountNumber,
        val account_number_code: AccountNumberCode,
        val address: String,
        val bank_id: BankId,
        val bank_id_code: BankIdCode,
        val name: String
)