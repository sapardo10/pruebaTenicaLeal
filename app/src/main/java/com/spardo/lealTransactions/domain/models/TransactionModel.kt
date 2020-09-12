package com.spardo.lealTransactions.domain.models

data class TransactionModel(
    val id: Int,
    val userId: Int,
    val createdDate: String,
    val commerce: CommerceModel,
    val branch: BranchModel,
    val seen: Boolean = false
)