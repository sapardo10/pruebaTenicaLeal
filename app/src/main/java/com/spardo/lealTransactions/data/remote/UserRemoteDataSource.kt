package com.spardo.lealTransactions.data.remote

import com.spardo.lealTransactions.data.network.LealApi
import com.spardo.lealTransactions.domain.mappers.toUserModel
import com.spardo.lealTransactions.domain.models.UserModel
import timber.log.Timber
import javax.inject.Inject

/**
 * Class in charge of handling all network requests about users
 * @author Sergio Pardo
 */
class UserRemoteDataSource @Inject constructor(
    private val lealApi: LealApi
) {

    /**
     * Get the user by the id
     */
    suspend fun getUser(userId: Long): UserModel? {
        return try {
            lealApi.getUser(userId).toUserModel()
        } catch (e: Exception) {
            Timber.e(e)
            null
        }
    }
}