package com.simplefinance.common.ui

import com.simplefinance.R

sealed class BottomNavItem(var title: String, var icon: Int, var screen_route: String) {

    object Home : BottomNavItem("Home", R.drawable.ic_launcher_foreground, "home")
    object MyNetwork : BottomNavItem("My Network", R.drawable.ic_launcher_foreground, "my_network")
    object AddPost : BottomNavItem("Post", R.drawable.ic_launcher_foreground, "add_post")
    object Notification :BottomNavItem("Notification", R.drawable.ic_launcher_foreground, "notification")
    object Jobs : BottomNavItem("Jobs", R.drawable.ic_launcher_foreground, "jobs")

    companion object{
        val items = listOf(
            BottomNavItem.Home,
            BottomNavItem.MyNetwork,
            BottomNavItem.AddPost,
            BottomNavItem.Notification,
            BottomNavItem.Jobs)

    }
}