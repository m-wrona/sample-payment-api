package com.mwronski.sample.payments.model

import javax.validation.constraints.NotNull

data class ChargesInformation(
        @field:NotNull(message = "BearerCode must be set")
        val bearerCode: String,
        @field:NotNull(message = "SenderCharges must be set")
        val senderCharges: List<SenderCharge>,
        @field:NotNull(message = "ReceiverChargesAmount must be set")
        val receiverChargesAmount: Double,
        @field:NotNull(message = "ReceiverChargesCurrency must be set")
        val receiverChargesCurrency: Currency
)