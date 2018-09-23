package com.mwronski.sample.payments.model

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
        val amount: Double,
        val beneficiaryParty: BeneficiaryParty,
        val chargesInformation: ChargesInformation,
        val currency: Currency,
        val debtorParty: DebtorParty,
        val endToEndReference: String,
        val fx: Fx,
        val numericReference: String,
        val paymentId: String,
        val paymentPurpose: String,
        val paymentScheme: PaymentScheme,
        val paymentType: PaymentType,
        val processingDate: String,
        val reference: String,
        val schemePaymentSubType: SchemaPaymentSubType,
        val schemePaymentType: SchemaPaymentType,
        val sponsorParty: SponsorParty
)