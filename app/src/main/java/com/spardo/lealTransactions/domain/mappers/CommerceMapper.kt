package com.spardo.lealTransactions.domain.mappers

import com.spardo.lealTransactions.data.database.relations.CommerceWithBranches
import com.spardo.lealTransactions.data.network.dto.CommerceDTO
import com.spardo.lealTransactions.domain.models.CommerceModel

fun CommerceDTO.toCommerceModel(): CommerceModel? {
    if (id == null || name == null || valueToPoints == null || branches == null) {
        return null
    }
    return CommerceModel(
        id = id,
        name = name,
        valueToPoints = valueToPoints,
        branches = branches.mapNotNull { it.toBranchModel() }.toList()
    )
}

fun CommerceWithBranches.toCommerceModel() = CommerceModel(
    id = commerce.id,
    name = commerce.name,
    valueToPoints = commerce.valueToPoints,
    branches = branches.map { it.toBranchModel() }.toList()
)