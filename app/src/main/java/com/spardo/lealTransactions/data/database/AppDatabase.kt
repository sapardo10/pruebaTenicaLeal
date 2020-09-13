package com.spardo.lealTransactions.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.spardo.lealTransactions.data.database.entity.BranchEntity
import com.spardo.lealTransactions.data.database.entity.CommerceBranchEntity
import com.spardo.lealTransactions.data.database.entity.CommerceEntity
import com.spardo.lealTransactions.data.database.entity.TransactionEntity
import com.spardo.lealTransactions.data.database.relations.CommerceWithBranches
import com.spardo.lealTransactions.data.database.relations.TransactionAndCommerceAndBranch

@Database(
    entities = [
        BranchEntity::class,
        CommerceBranchEntity::class,
        CommerceEntity::class,
        TransactionEntity::class,
        CommerceWithBranches::class,
        TransactionAndCommerceAndBranch::class
    ], version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun transactionDao(): TransactionDao

}