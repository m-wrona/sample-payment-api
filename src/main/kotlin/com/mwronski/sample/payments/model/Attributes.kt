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
        val beneficiary_party: BeneficiaryParty,
        val charges_information: ChargesInformation,
        val currency: Currency,
        val debtor_party: DebtorParty,
        val end_to_end_reference: String,
        val fx: Fx,
        val numeric_reference: String,
        val payment_id: String,
        val payment_purpose: String,
        val payment_scheme: PaymentScheme,
        val payment_type: PaymentType,
        val processing_date: String,
        val reference: String,
        val scheme_payment_sub_type: SchemaPaymentSubType,
        val scheme_payment_type: SchemaPaymentType,
        val sponsor_party: SponsorParty
)