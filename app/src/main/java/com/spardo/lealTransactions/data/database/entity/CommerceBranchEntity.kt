package com.spardo.lealTransactions.data.database.entity

import androidx.room.Entity

@Entity(tableName = "commerce_branch", primaryKeys = ["commerceId", "branchId"])
data class CommerceBranchEntity(
    val commerceId: Long,
    val branchId: Long
)