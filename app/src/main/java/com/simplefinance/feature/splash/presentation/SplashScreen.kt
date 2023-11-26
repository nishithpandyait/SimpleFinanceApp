package com.simplefinance.feature.splash.presentation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.navigation.NavController
import com.simplefinance.feature.navigation.data.model.Screens
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    Text(style = TextStyle(color = Color.Red), text = "Splash", modifier = Modifier)
    LaunchedEffect(key1 = true) {
        delay(2000)
        navController.popBackStack()
        navController.navigate(Screens.News.route)
    }
}