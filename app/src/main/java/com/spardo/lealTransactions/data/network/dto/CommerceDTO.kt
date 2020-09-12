package com.spardo.lealTransactions.data.network.dto

import com.google.gson.annotations.SerializedName

data class CommerceDTO(
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("valueToPoints") val valueToPoints: Int?,
    @SerializedName("branches") val branches: List<BranchDTO>?
)