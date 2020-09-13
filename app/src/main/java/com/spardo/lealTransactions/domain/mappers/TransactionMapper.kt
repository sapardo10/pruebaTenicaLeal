package com.spardo.lealTransactions.domain.mappers

import com.spardo.lealTransactions.data.database.relations.TransactionAndCommerceAndBranch
import com.spardo.lealTransactions.data.network.dto.TransactionDTO
import com.spardo.lealTransactions.domain.models.TransactionModel

fun TransactionDTO.toTransactionModel(): TransactionModel? {
    val commerceModel = commerce?.toCommerceModel()
    val branchModel = branch?.toBranchModel()
    if (id == null || userId == null || createdDate == null || commerceModel == null || branchModel == null) {
        return null
    }
    return TransactionModel(
        id = id,
        userId = userId,
        createdDate = createdDate,
        commerce = commerceModel,
        branch = branchModel,
        seen = false
    )
}

fun TransactionAndCommerceAndBranch.toTransactionModel() = TransactionModel(
    id = transaction.id,
    userId = transaction.userId,
    createdDate = transaction.createdDate,
    commerce = commerceEntity.toCommerceModel(),
    branch = branchEntity.toBranchModel(),
    seen = transaction.seen
)
