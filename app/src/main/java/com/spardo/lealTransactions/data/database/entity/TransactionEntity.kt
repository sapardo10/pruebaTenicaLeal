package com.spardo.lealTransactions.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transaction")
data class TransactionEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: Long,
    @ColumnInfo(name = "userId") val userId: Long,
    @ColumnInfo(name = "createdDate") val createdDate: String,
    @ColumnInfo(name = "commerceId") val commerce: Long,
    @ColumnInfo(name = "branchId") val branch: Long,
    @ColumnInfo(name = "seen") val seen: Boolean
)