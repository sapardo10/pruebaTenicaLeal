package com.spardo.lealTransactions.data.network.dto

import com.google.gson.annotations.SerializedName

data class UserDTO(
    @SerializedName("id") val id: Long?,
    @SerializedName("createdDate") val createdDate: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("birthday") val birthday: String?,
    @SerializedName("photo") val photo: String?
)