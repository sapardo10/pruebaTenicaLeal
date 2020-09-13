package com.spardo.lealTransactions.data.database

import androidx.room.*
import com.spardo.lealTransactions.data.database.relations.TransactionAndCommerceAndBranch

@Dao
interface TransactionDao {

    @Transaction
    @Query("SELECT * FROM `transaction`")
    fun getAll(): List<TransactionAndCommerceAndBranch>

    @Insert
    suspend fun insertAll(transactions: List<TransactionAndCommerceAndBranch>)

    @Delete
    suspend fun delete(transaction: TransactionAndCommerceAndBranch)

}