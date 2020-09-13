package com.spardo.lealTransactions.domain.mappers

import com.spardo.lealTransactions.data.database.entity.BranchEntity
import com.spardo.lealTransactions.data.network.dto.BranchDTO
import com.spardo.lealTransactions.domain.models.BranchModel

fun BranchDTO.toBranchModel(): BranchModel? {
    if (id == null || name == null) {
        return null
    }
    return BranchModel(
        id = id,
        name = name
    )
}

fun BranchEntity.toBranchModel() = BranchModel(
    id = id,
    name = name
)
