package com.spardo.lealTransactions.data.network

import com.spardo.lealTransactions.data.network.dto.TransactionDTO
import retrofit2.http.GET

interface LealApi {

    @GET("/transactions")
    suspend fun getTransactions(): List<TransactionDTO>
}