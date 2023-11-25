package com.simplefinance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.simplefinance.common.ui.BaseUiModel
import com.simplefinance.feature.news.presentation.ui.NewsScreen
import com.simplefinance.feature.news.presentation.viewmodel.NewsViewModel
import com.simplefinance.feature.splash.presentation.SplashScreen
import com.simplefinance.ui.Screens
import com.simplefinance.ui.theme.SimpleFinanceAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val viewModel: NewsViewModel by viewModels()

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SimpleFinanceAppTheme {
                val collectAsState by viewModel.uiData.collectAsState(BaseUiModel())
                val navController = rememberNavController()
                // A surface container using the 'background' color from the theme
                Scaffold(
                    topBar = {
                        TopAppBar(title = {
                            Text(text = "Simple Finance App")
                        })
                    },
                    bottomBar = {
                        BottomAppBar(
                            containerColor = MaterialTheme.colorScheme.primaryContainer,
                            contentColor = MaterialTheme.colorScheme.primary,
                        ) {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                text = "Bottom app bar",
                            )
                        }
                    },
                    floatingActionButton = {
                        FloatingActionButton(onClick = { }) {
                            Icon(Icons.Default.Add, contentDescription = "Add")
                        }
                    }) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                    ) {
                        GetNavHost(navController = navController)

                    } /*{
                    //content
                    *//*
                     }*//*
                    Text(style = TextStyle(color = Color.Blue), text = "Hello")
                    //
                    it

                }*/
                }
            }
        }
    }

    @Composable
    fun GetBottomBar() {

    }

    @Composable
    fun GetNavHost(navController: NavHostController) {
        NavHost(navController = navController, startDestination = Screens.Splash.route) {
            composable(Screens.Details.route + "?id={uid}") { Text(text = "Profile") }
            composable(Screens.Profile.route) { Text(text = "friendlist") }
            composable(Screens.News.route) { NewsScreen(navController = navController,viewModel) }
            composable(Screens.Splash.route) { SplashScreen(navController = navController) }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        SimpleFinanceAppTheme {


        }
    }
}