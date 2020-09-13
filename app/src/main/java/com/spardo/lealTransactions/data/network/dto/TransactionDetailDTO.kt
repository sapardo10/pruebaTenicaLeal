package com.spardo.lealTransactions.data.network.dto

import com.google.gson.annotations.SerializedName

data class TransactionDetailDTO(
    @SerializedName("transactionId") val id: Long?,
    @SerializedName("value") val value: Double?,
    @SerializedName("points") val points: Double?
)