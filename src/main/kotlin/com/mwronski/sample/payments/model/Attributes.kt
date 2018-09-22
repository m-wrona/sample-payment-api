package com.mwronski.sample.payments.model

data class Attributes(
        val amount: String,
        val beneficiary_party: BeneficiaryParty,
        val charges_information: ChargesInformation,
        val currency: String,
        val debtor_party: DebtorParty,
        val end_to_end_reference: String,
        val fx: Fx,
        val numeric_reference: String,
        val payment_id: String,
        val payment_purpose: String,
        val payment_scheme: String,
        val payment_type: String,
        val processing_date: String,
        val reference: String,
        val scheme_payment_sub_type: String,
        val scheme_payment_type: String,
        val sponsor_party: SponsorParty
)