package com.spardo.lealTransactions.data.network.dto

import com.google.gson.annotations.SerializedName

data class TransactionDTO(
    @SerializedName("id") val id: Int?,
    @SerializedName("userId") val userId: Int?,
    @SerializedName("createdDate") val createdDate: String?,
    @SerializedName("commerce") val commerce: CommerceDTO?,
    @SerializedName("branch") val branch: BranchDTO?
)