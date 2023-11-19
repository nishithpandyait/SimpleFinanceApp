package com.simplefinance.ui

sealed class Screens(val route: String) {
    object Profile : Screens("profile")
    object Details : Screens("details")
    object News : Screens("news")
    object Splash : Screens("splash")
}
