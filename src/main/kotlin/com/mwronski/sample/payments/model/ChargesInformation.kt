package com.mwronski.sample.payments.model

data class ChargesInformation(
        val bearer_code: String,
        val sender_charges: List<SenderCharge>,
        val receiver_charges_amount: String,
        val receiver_charges_currency: String
)