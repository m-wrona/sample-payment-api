package com.mwronski.sample.payments.model

data class ChargesInformation(
        val bearerCode: String,
        val senderCharges: List<SenderCharge>,
        val receiverChargesAmount: Double,
        val receiverChargesCurrency: Currency
)