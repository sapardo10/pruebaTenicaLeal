package com.spardo.lealTransactions.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.spardo.lealTransactions.BuildConfig
import com.spardo.lealTransactions.exceptions.ClassNameNotDefinedException

/**
 * Class that will be the parent of all activity classes of the application
 * @author Sergio Pardo
 */
abstract class BaseActivity : AppCompatActivity() {

    //Variables
    open var className: String? = null

    //Lifecycle methods

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        if (className == null && BuildConfig.DEBUG) {
            throw ClassNameNotDefinedException()
        }
        super.onCreate(savedInstanceState, persistentState)
    }
}