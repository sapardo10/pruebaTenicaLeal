package com.spardo.lealTransactions.presentation.splash

import android.os.Bundle
import android.os.PersistableBundle
import com.spardo.lealTransactions.R
import com.spardo.lealTransactions.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : BaseActivity(){
    // Companion
    companion object {
        const val screenName = "Splash"
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        className = screenName
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_splash)
    }
}