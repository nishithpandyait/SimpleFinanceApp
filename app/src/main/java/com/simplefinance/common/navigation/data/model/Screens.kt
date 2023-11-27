package com.simplefinance.common.navigation.data.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.ui.graphics.vector.ImageVector
import com.simplefinance.R

sealed class Screens(
    val route: String,
    var image: ImageVector,
    var imageUnselected: ImageVector,
    var selected: Boolean = false,
    var badgeText: String = ""
) {
    object Login : Screens("Login", image = Icons.Filled.Home, imageUnselected = Icons.Outlined.Home)

    object Profile : Screens("Profile", image = Icons.Filled.Home, imageUnselected = Icons.Outlined.Home)

    object Details : Screens("Details",image = Icons.Filled.AccountCircle,imageUnselected = Icons.Outlined.AccountCircle)

    object News : Screens("News", image = Icons.Filled.Info, imageUnselected = Icons.Outlined.Info)
    object Splash : Screens("Splash", image = Icons.Filled.Home, imageUnselected = Icons.Outlined.Home)
}
