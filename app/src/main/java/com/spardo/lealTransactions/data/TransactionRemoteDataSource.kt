package com.spardo.lealTransactions.data

import com.spardo.lealTransactions.data.network.LealApi
import com.spardo.lealTransactions.domain.models.TransactionModel
import javax.inject.Inject

/**
 * Class in charge of handling all network requests about transactions
 * @author Sergio Pardo
 */
class TransactionRemoteDataSource @Inject constructor(
    private val lealApi: LealApi
) {
    fun getTransactions(): List<TransactionModel> {
        return emptyList()
    }
}