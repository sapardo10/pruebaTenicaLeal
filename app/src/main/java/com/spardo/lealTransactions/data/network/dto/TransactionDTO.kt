package com.spardo.lealTransactions.data.network.dto

import com.google.gson.annotations.SerializedName

data class TransactionDTO(
    @SerializedName("id") val id: Long?,
    @SerializedName("userId") val userId: Long?,
    @SerializedName("createdDate") val createdDate: String?,
    @SerializedName("commerce") val commerce: CommerceDTO?,
    @SerializedName("branch") val branch: BranchDTO?
)