package com.mwronski.sample.payments.model

data class ChargesInformation(
        val bearer_code: String,
        val sender_charges: List<SenderCharge>,
        val receiver_charges_amount: Double,
        val receiver_charges_currency: Currency
)