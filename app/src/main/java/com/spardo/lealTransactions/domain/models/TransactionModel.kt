package com.spardo.lealTransactions.domain.models

data class TransactionModel(
    val id: Long,
    val userId: Long,
    val createdDate: String,
    val commerce: CommerceModel,
    val branch: BranchModel,
    val seen: Boolean = false
)