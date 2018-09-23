package com.mwronski.sample.payments.test

import com.mwronski.sample.payments.http.NewDataRequest
import com.mwronski.sample.payments.model.*

internal object PaymentsTestData {

    fun newValidPayment(organizationId: String = "organization-1") = NewDataRequest(
            id = null,
            organisationId = organizationId,
            type = DataType.Payment,
            attributes = Attributes(
                    amount = 100.21,
                    currency = "GPB",
                    endToEndReference = "Wil piano Jan",
                    numericReference = "1002001",
                    paymentId = "123456789012345678",
                    paymentPurpose = "Paying for goods/services",
                    paymentScheme = PaymentScheme.FPS,
                    paymentType = PaymentType.Credit,
                    processingDate = "2017-01-18",
                    reference = "Payment for Em's piano lessons",
                    schemePaymentSubType = SchemaPaymentSubType.InternetBanking,
                    schemePaymentType = SchemaPaymentType.ImmediatePayment,
                    sponsorParty = SponsorParty(
                            accountNumber = "56781234",
                            bankId = "123123",
                            bankIdCode = "GBDSC"
                    ),
                    beneficiaryParty = BeneficiaryParty(
                            accountName = "W Owens",
                            accountNumber = "31926819",
                            accountNumberCode = "BBAN",
                            accountType = 0,
                            address = "1 The Beneficiary Localtown SE2",
                            bankId = "403000",
                            bankIdCode = "GBDSC",
                            name = "Wilfred Jeremiah Owens"
                    ),
                    chargesInformation = ChargesInformation(
                            bearerCode = "SHAR",
                            receiverChargesAmount = 1.0,
                            receiverChargesCurrency = "USD",
                            senderCharges = listOf(
                                    SenderCharge(amount = 5.0, currency = "GBP"),
                                    SenderCharge(amount = 10.0, currency = "USD")
                            )
                    ),
                    fx = Fx(
                            contractReference = "FX123",
                            exchangeRate = 2.0,
                            originalAmount = 200.42,
                            originalCurrency = "USD"
                    ),
                    debtorParty = DebtorParty(
                            accountName = "EJ Brown Black",
                            accountNumber = "GB29XABC10161234567801",
                            accountNumberCode = "IBAN",
                            address = "10 Debtor Crescent Sourcetown NE1",
                            bankId = "203301",
                            bankIdCode = "GBDSC",
                            name = "Emelia Jane Brown"
                    )
            )
    )

    fun newInvalidPayment() = newValidPayment().copy(organisationId = "", id = "some-id")

}