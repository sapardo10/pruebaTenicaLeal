package com.spardo.lealTransactions.data

import com.spardo.lealTransactions.data.database.TransactionDao
import com.spardo.lealTransactions.domain.mappers.toTransactionModel
import com.spardo.lealTransactions.domain.models.TransactionModel
import timber.log.Timber
import javax.inject.Inject

/**
 * Class that will handle all database transactions related to transactions
 * @author Sergio Pardo
 */
class TransactionLocalDataSource @Inject constructor(
    private val transactionDao: TransactionDao
) {
    fun getTransactions(): List<TransactionModel> {
        return try {
            transactionDao.getAll().map { it.toTransactionModel() }.toList()
        } catch (e: Exception) {
            Timber.e(e)
            emptyList()
        }
    }

}