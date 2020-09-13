package com.spardo.lealTransactions.data.database.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.spardo.lealTransactions.data.database.entity.BranchEntity
import com.spardo.lealTransactions.data.database.entity.CommerceBranchEntity
import com.spardo.lealTransactions.data.database.entity.CommerceEntity

data class CommerceWithBranches(
    @Embedded val commerce: CommerceEntity,
    @Relation(
        parentColumn = "commerceId",
        entityColumn = "branchId",
        associateBy = Junction(CommerceBranchEntity::class)
    )
    val branches: List<BranchEntity>
)