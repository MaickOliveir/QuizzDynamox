package com.geo.commons.view

import android.os.Bundle
import androidx.annotation.NavigationRes
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.geo.commons.R
import com.geo.commons.extension.defaultNavController

abstract class BaseNavActivity<VM : ViewModel> : BaseActivity() {

    lateinit var viewModelFactory: ViewModelFactory

    protected lateinit var viewModel: VM

    protected lateinit var navController: NavController

    protected open val layout: Int = R.layout.activity_navigation

    abstract fun viewModelClass(): Class<VM>

    @NavigationRes
    abstract fun navGraph(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)
        navController = defaultNavController(navGraph())
    }
}