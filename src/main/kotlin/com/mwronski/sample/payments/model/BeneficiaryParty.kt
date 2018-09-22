package com.mwronski.sample.payments.model

data class BeneficiaryParty(
        val account_name: String,
        val account_number: String,
        val account_number_code: String,
        val account_type: Int,
        val address: String,
        val bank_id: String,
        val bank_id_code: String,
        val name: String
)