package com.spardo.lealTransactions.domain.models

data class UserModel(
    val id: Long,
    val createdDate: String,
    val name: String,
    val birthday: String,
    val photo: String
)