package com.spardo.lealTransactions.data.network.dto

import com.google.gson.annotations.SerializedName

data class BranchDTO(
    @SerializedName("id") val id: Long?,
    @SerializedName("name") val name: String?
)