package com.mwronski.sample.payments.model

enum class DataType {
    Payment
}

typealias DataId = String

data class Data(
        val type: DataType,
        val id: DataId,
        val version: Int,
        val organisationId: String,
        val attributes: Attributes
)