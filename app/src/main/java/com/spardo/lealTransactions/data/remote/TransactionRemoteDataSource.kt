package com.spardo.lealTransactions.data.remote

import com.spardo.lealTransactions.data.network.LealApi
import com.spardo.lealTransactions.domain.mappers.toTransactionDetailModel
import com.spardo.lealTransactions.domain.mappers.toTransactionModel
import com.spardo.lealTransactions.domain.models.TransactionDetailModel
import com.spardo.lealTransactions.domain.models.TransactionModel
import timber.log.Timber
import javax.inject.Inject

/**
 * Class in charge of handling all network requests about transactions
 * @author Sergio Pardo
 */
class TransactionRemoteDataSource @Inject constructor(
    private val lealApi: LealApi
) {

    /**
     * Method that gets the details of a transaction
     */
    suspend fun getTransactionDetailById(transactionId: Int): TransactionDetailModel? {
        return try {
            lealApi.getTransactionDetail(transactionId).toTransactionDetailModel()
        } catch (e: Exception) {
            Timber.e(e)
            null
        }
    }

    /**
     * Method that get the list of [TransactionModel]
     */
    suspend fun getTransactions(): List<TransactionModel> {
        return try {
            lealApi.getTransactions().mapNotNull { it.toTransactionModel() }.toList()
        } catch (e: Exception) {
            Timber.e(e)
            emptyList()
        }
    }
}