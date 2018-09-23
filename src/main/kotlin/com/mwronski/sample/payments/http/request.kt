package com.mwronski.sample.payments.http

import com.mwronski.sample.payments.model.Attributes
import com.mwronski.sample.payments.model.Data
import com.mwronski.sample.payments.model.DataId
import com.mwronski.sample.payments.model.DataType
import org.hibernate.validator.constraints.Length
import java.util.*
import javax.validation.constraints.NotNull
import javax.validation.constraints.Null

/**
 * Request for creating new data.
 * Request doesn't have fields that will be set by backend during processing.
 *
 * @see com.mwronski.sample.payments.model.Data
 */
data class NewDataRequest(
        @field:NotNull(message = "Type must be set")
        val type: DataType,
        @field:Null(message = "ID must be empty")
        var id: DataId? = null,
        @field:Length(message = "OrganizationId must be set", min = 3)
        val organisationId: String,
        @field:NotNull(message = "Attributes must be set")
        val attributes: Attributes
) {

    fun toData() = Data(
            type = this.type,
            id = UUID.randomUUID().toString(),
            version = 0,
            organisationId = this.organisationId,
            attributes = this.attributes
    )

}
