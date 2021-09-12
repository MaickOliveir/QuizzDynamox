package com.geo.commons.extension

import android.app.Activity
import android.os.Bundle
import androidx.annotation.IdRes
import androidx.annotation.NavigationRes
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import com.geo.commons.R

fun Activity.defaultNavController(
    @NavigationRes navGraphId: Int
) = findNavController(R.id.fragment_container).apply{
    graph = navInflater.inflate(navGraphId)
}

fun NavController.defaultNavigate(
    @IdRes resId: Int,
    args: Bundle? = null,
    popStack: Boolean = false,
    navOptionsBuilder: NavOptions.Builder = defaultNavOptionsBuilder()
) {
    val navOptions = navOptionsBuilder
        .apply { if (popStack) setPopUpTo(graph.id, true) }
        .build()

    navigate(resId, args, navOptions)
}

fun defaultNavOptionsBuilder() =  NavOptions.Builder()
    .setEnterAnim(R.anim.nav_default_enter_anim)
    .setExitAnim(R.anim.nav_default_exit_anim)
