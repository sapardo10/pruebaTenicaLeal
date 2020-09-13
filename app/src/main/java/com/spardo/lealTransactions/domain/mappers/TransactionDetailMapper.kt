package com.spardo.lealTransactions.domain.mappers

import com.spardo.lealTransactions.data.network.dto.TransactionDetailDTO
import com.spardo.lealTransactions.domain.models.TransactionDetailModel

fun TransactionDetailDTO.toTransactionDetailModel(): TransactionDetailModel? {
    if(id == null || value == null || points == null){
        return null
    }
    return TransactionDetailModel(
        id = id,
        value = value,
        points = points
    )
}