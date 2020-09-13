package com.spardo.lealTransactions.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.spardo.lealTransactions.BuildConfig
import com.spardo.lealTransactions.exceptions.ClassNameNotDefinedException
import timber.log.Timber

/**
 * Class that will be the parent of all activity classes of the application
 * @author Sergio Pardo
 */
abstract class BaseActivity : AppCompatActivity() {

    companion object {
        const val onCreate = "onCreate"
        const val onDestroy = "onDestroy"
        const val onPause = "onPause"
        const val onResume = "onResume"
        const val onStart = "onStart"
        const val onStop = "onStop"
    }

    //Variables
    open var className: String? = null

    //Lifecycle methods

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        if (className == null && BuildConfig.DEBUG) {
            throw ClassNameNotDefinedException()
        }
        Timber.d(onCreate)
        super.onCreate(savedInstanceState, persistentState)
    }

    override fun onStart() {
        Timber.d(onStart)
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
        Timber.d(onResume)
    }

    override fun onPause() {
        Timber.d(onPause)
        super.onPause()
    }

    override fun onStop() {
        Timber.d(onStop)
        super.onStop()
    }
}