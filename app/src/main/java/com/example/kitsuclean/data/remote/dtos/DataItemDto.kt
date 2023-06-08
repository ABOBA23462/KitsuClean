package com.example.kitsueasyclean.data.remote.dtos

import com.example.kitsueasyclean.domain.models.DataItem
import com.google.gson.annotations.SerializedName

data class DataItemDto(
    @SerializedName("id")
    val id: String,
    @SerializedName("attributes")
    val attributes: AttributesDto,
    @SerializedName("type")
    val type: String
)

fun DataItemDto.toDomain(): DataItem {
    return DataItem(id, attributes.toDomain(), type)
}
