package com.spardo.lealTransactions.data.network

import com.spardo.lealTransactions.data.network.dto.TransactionDTO
import com.spardo.lealTransactions.data.network.dto.TransactionDetailDTO
import com.spardo.lealTransactions.data.network.dto.UserDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface LealApi {

    @GET("/transactions/{transaction_id}/info")
    suspend fun getTransactionDetail(@Path("transaction_id") transactionId: Int): TransactionDetailDTO

    @GET("/transactions")
    suspend fun getTransactions(): List<TransactionDTO>

    @GET("/users/{user_id}")
    suspend fun getUser(@Path("user_id") userId: Long): UserDTO
}