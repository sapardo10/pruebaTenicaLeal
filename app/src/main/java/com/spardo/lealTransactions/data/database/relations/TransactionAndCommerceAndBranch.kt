package com.spardo.lealTransactions.data.database.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.spardo.lealTransactions.data.database.entity.BranchEntity
import com.spardo.lealTransactions.data.database.entity.TransactionEntity

data class TransactionAndCommerceAndBranch(
    @Embedded val transaction: TransactionEntity,
    @Relation(
        parentColumn = "commerceId",
        entityColumn = "id"
    )
    val commerceEntity: CommerceWithBranches,
    @Relation(
        parentColumn = "branchId",
        entityColumn = "id"
    )
    val branchEntity: BranchEntity
)