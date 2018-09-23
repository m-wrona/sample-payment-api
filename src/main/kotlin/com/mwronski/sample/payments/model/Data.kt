package com.mwronski.sample.payments.model

import org.hibernate.validator.constraints.Length
import javax.validation.constraints.NotNull

enum class DataType {
    Payment
}

typealias DataId = String

data class Data(
        @field:NotNull(message = "Type must be set")
        val type: DataType,
        @field:NotNull(message = "ID must be set")
        val id: DataId,
        @field:NotNull(message = "Version must be set")
        var version: Int,
        @field:Length(message = "OrganizationId must be set", min = 3)
        val organisationId: String,
        @field:NotNull(message = "Attributes must be set")
        val attributes: Attributes
)