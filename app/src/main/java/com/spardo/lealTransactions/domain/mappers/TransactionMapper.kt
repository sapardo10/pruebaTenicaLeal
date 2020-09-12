package com.spardo.lealTransactions.domain.mappers

import com.spardo.lealTransactions.data.network.dto.TransactionDTO
import com.spardo.lealTransactions.domain.models.TransactionModel

fun TransactionDTO.toTransactionModel(): TransactionModel? {
    val commerceModel = commerce?.toCommerceModel()
    val branchModel = branch?.toBranchModel()
    if (id == null || userId == null || createdDate == null || commerceModel == null || branchModel == null) {
        return null
    }
    return TransactionModel(
        id = 0,
        userId = 0,
        createdDate = "",
        commerce = commerceModel,
        branch = branchModel,
        seen = false
    )
}