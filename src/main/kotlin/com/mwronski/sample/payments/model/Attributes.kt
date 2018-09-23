package com.mwronski.sample.payments.model

import javax.validation.constraints.NotNull

enum class PaymentScheme {
    FPS
}

enum class PaymentType {
    Credit
}

enum class SchemaPaymentType {
    ImmediatePayment
}

enum class SchemaPaymentSubType {
    InternetBanking
}

data class Attributes(
        @field:NotNull(message = "Amount must be set")
        val amount: Double,
        @field:NotNull(message = "BeneficiaryParty must be set")
        val beneficiaryParty: BeneficiaryParty,
        @field:NotNull(message = "ChargesInformation must be set")
        val chargesInformation: ChargesInformation,
        @field:NotNull(message = "Currency must be set")
        val currency: Currency,
        @field:NotNull(message = "DebtorParty must be set")
        val debtorParty: DebtorParty,
        @field:NotNull(message = "EndToEndReference must be set")
        val endToEndReference: String,
        @field:NotNull(message = "FX must be set")
        val fx: Fx,
        @field:NotNull(message = "NumericReference must be set")
        val numericReference: String,
        @field:NotNull(message = "PaymentId must be set")
        val paymentId: String,
        @field:NotNull(message = "PaymentPurpose must be set")
        val paymentPurpose: String,
        @field:NotNull(message = "PaymentScheme must be set")
        val paymentScheme: PaymentScheme,
        @field:NotNull(message = "PaymentType must be set")
        val paymentType: PaymentType,
        @field:NotNull(message = "ProcessingDate must be set")
        val processingDate: String,
        @field:NotNull(message = "Reference must be set")
        val reference: String,
        @field:NotNull(message = "SchemaPaymentSubType must be set")
        val schemePaymentSubType: SchemaPaymentSubType,
        @field:NotNull(message = "SchemaPaymentType must be set")
        val schemePaymentType: SchemaPaymentType,
        @field:NotNull(message = "SponsorParty must be set")
        val sponsorParty: SponsorParty
)