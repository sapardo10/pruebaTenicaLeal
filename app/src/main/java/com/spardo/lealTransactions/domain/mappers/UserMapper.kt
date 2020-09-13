package com.spardo.lealTransactions.domain.mappers

import com.spardo.lealTransactions.base.GeneralConstants.DEFAULT_EMPTY_STRING
import com.spardo.lealTransactions.data.network.dto.UserDTO
import com.spardo.lealTransactions.domain.models.UserModel

fun UserDTO.toUserModel(): UserModel? {
    if (id == null) {
        return null
    }
    return UserModel(
        id = id,
        createdDate = createdDate ?: DEFAULT_EMPTY_STRING,
        name = name ?: DEFAULT_EMPTY_STRING,
        birthday = birthday ?: DEFAULT_EMPTY_STRING,
        photo = photo ?: DEFAULT_EMPTY_STRING
    )
}