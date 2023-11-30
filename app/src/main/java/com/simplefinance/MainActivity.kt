package com.simplefinance

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.simplefinance.common.ui.BaseUiModel
import com.simplefinance.common.navigation.data.model.Screens
import com.simplefinance.feature.login.presentation.ui.LoginScreen
import com.simplefinance.feature.login.presentation.viewmodel.LoginViewModel
import com.simplefinance.feature.news.presentation.ui.NewsScreen
import com.simplefinance.feature.news.presentation.viewmodel.NewsViewModel
import com.simplefinance.feature.splash.presentation.SplashScreen
import com.simplefinance.ui.theme.SimpleFinanceAppTheme
import com.simplefinance.ui.theme.spacing_medium
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleFinanceAppTheme {

                val navController = rememberNavController()
                // A surface container using the 'background' color from the theme
                var isFabVisible by remember {
                    mutableStateOf(false)
                }
                DisposableEffect(navController) {
                    val listener = NavController.OnDestinationChangedListener { _, destination, _ ->
                        // Set isBottomBarVisible based on the destination
                        isFabVisible =
                            destination.route !in setOf(Screens.Splash.route, Screens.Login.route)
                    }
                    navController.addOnDestinationChangedListener(listener)
                    onDispose {
                        navController.removeOnDestinationChangedListener(listener)
                    }
                }
                Scaffold(
                    topBar = {
                        TopAppBar(title = {
                            Text(text = "Simple Finance App")
                        })
                    },
                    bottomBar = {
                        GetBottomBar(navController)
                    },
                    floatingActionButton = {
                        if (isFabVisible) {
                            FloatingActionButton(onClick = { }) {
                                Icon(
                                    Icons.Default.Add,
                                    contentDescription = getString(R.string.add)
                                )
                            }
                        }
                    }) { innerPadding ->
                    Column(
                        modifier = Modifier.padding(innerPadding),
                        verticalArrangement = Arrangement.spacedBy(spacing_medium),
                    ) {
                        GetNavHost(navController = navController)
                    }
                }
            }
        }
    }

    @Composable
    fun GetBottomBar(navController: NavHostController) {
        val navigationScreens =
            setOf<Screens>(Screens.News, Screens.Details, Screens.Profile)
        var isBottomBarVisible by remember {
            mutableStateOf(false)
        }
        DisposableEffect(navController) {
            val listener = NavController.OnDestinationChangedListener { _, destination, _ ->
                // Set isBottomBarVisible based on the destination
                isBottomBarVisible =
                    destination.route !in setOf(Screens.Splash.route, Screens.Login.route)
            }
            navController.addOnDestinationChangedListener(listener)
            onDispose {
                navController.removeOnDestinationChangedListener(listener)
            }
        }
        if (isBottomBarVisible) {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
            ) {
                for (it in navigationScreens) {
                    NavigationBarItem(selected = it.selected,
                        modifier = Modifier,
                        onClick = {
                            it.selected = it.selected
                            navController.popBackStack()
                            navController.navigate(it.route)
                        },
                        icon = {
                            Image(
                                imageVector = if (it.selected) it.image else it.imageUnselected,
                                contentDescription = it.route + if (it.selected) {
                                    stringResource(R.string.selected)
                                } else {
                                    ""
                                }
                            )
                        },
                        enabled = true,
                        label = { Text(text = it.route + it.badgeText) }
                    )
                }

            }
        }


    }

    fun normalFunction() {
        Toast.makeText(this@MainActivity, "", Toast.LENGTH_SHORT).show()
    }

    @Composable
    fun GetNavHost(navController: NavHostController) {
        NavHost(navController = navController, startDestination = Screens.Splash.route) {
            composable(Screens.Details.route + "?id={uid}") { Text(text = "Profile") }
            composable(Screens.Profile.route) { Text(text = "friendlist") }
            composable(Screens.News.route) { NewsScreen(navController = navController) }
            composable(Screens.Splash.route) { SplashScreen(navController = navController) }
            composable(Screens.Login.route) {
                LoginScreen(navController = navController)
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        SimpleFinanceAppTheme {

        }
    }
}