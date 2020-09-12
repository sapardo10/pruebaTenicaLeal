package com.spardo.lealTransactions.domain.models

data class CommerceModel(
    val id: Int,
    val name: String,
    val valueToPoints: Int,
    val branches: List<BranchModel>
)