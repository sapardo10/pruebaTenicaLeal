package com.spardo.lealTransactions

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

import timber.log.Timber.DebugTree


/**
 * Class that represents the application as a process on the OS. Any logic or code that involves
 * the entire lifecycle of the application could go here.
 * @author Sergio Pardo
 */
@HiltAndroidApp
class LealTransactionsApplication : Application() {

    // Lifecycle

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        } else {
            //TODO implement tree for release (Firebase, Fabric, InstaBug, etc...)
            Timber.plant(DebugTree())
        }
    }
}
