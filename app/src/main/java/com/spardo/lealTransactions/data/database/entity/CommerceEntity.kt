package com.spardo.lealTransactions.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.spardo.lealTransactions.data.network.dto.BranchDTO

@Entity(tableName = "commerce")
data class CommerceEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: Long,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "valueToPoints") val valueToPoints: Double
)