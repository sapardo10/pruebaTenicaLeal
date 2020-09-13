package com.spardo.lealTransactions.domain.models

data class CommerceModel(
    val id: Long,
    val name: String,
    val valueToPoints: Double,
    val branches: List<BranchModel>
)