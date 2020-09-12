package com.spardo.lealTransactions.presentation.home

import android.os.Bundle
import com.spardo.lealTransactions.R
import com.spardo.lealTransactions.base.BaseActivity
import com.spardo.lealTransactions.databinding.ActivityHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_home.*


/**
 * Activity that will hold the views presented to the user on the home screen
 */
@AndroidEntryPoint
class HomeActivity : BaseActivity() {

    //Companion
    companion object {
        const val screenName = "Home"
    }

    // Variables

    private lateinit var binding: ActivityHomeBinding

    //Lifecycle methods

    override fun onCreate(savedInstanceState: Bundle?) {
        className =
            screenName
        super.onCreate(savedInstanceState)
        setUpView()


        collapsing_toolbar_layout.title = "Transacciones"
        collapsing_toolbar_layout.setCollapsedTitleTextAppearance(R.style.collapsedToolbarStyle)
        collapsing_toolbar_layout.setExpandedTitleTextAppearance(R.style.expandedToolbarStyle)
    }

    //Private methods
    /**
     * Method that setups the view on the screen
     */
    private fun setUpView() {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}