package com.spardo.lealTransactions.domain.mappers

import com.spardo.lealTransactions.data.network.dto.CommerceDTO
import com.spardo.lealTransactions.domain.models.BranchModel
import com.spardo.lealTransactions.domain.models.CommerceModel

fun CommerceDTO.toCommerceModel(): CommerceModel? {
    if(id == null || name == null || valueToPoints == null || branches == null){
        return null
    }
    return CommerceModel(
        id = 0,
        name = "",
        valueToPoints = 0,
        branches = branches.mapNotNull { it.toBranchModel() }.toList()
    )
}