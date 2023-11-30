package com.simplefinance.feature.news.presentation.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.simplefinance.feature.news.presentation.model.NewsErrorUiState
import com.simplefinance.feature.news.presentation.model.NewsUiState
import com.simplefinance.feature.news.presentation.viewmodel.NewsViewModel

@Composable
fun NewsScreen(navController: NavController, viewModel: NewsViewModel = hiltViewModel()) {
    val uiData by viewModel.uiData.collectAsState()

    when (uiData) {
        is NewsErrorUiState -> {
            Text(text = (uiData as NewsErrorUiState).name)
        }

        is NewsUiState -> {
            Text(text = (uiData as NewsUiState).error)
        }
    }
}