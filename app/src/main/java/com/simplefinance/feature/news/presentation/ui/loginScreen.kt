package com.simplefinance.feature.news.presentation.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import com.simplefinance.feature.news.presentation.model.NewsUiState
import com.simplefinance.feature.news.presentation.model.NewsErrorUiState
import com.simplefinance.feature.news.presentation.viewmodel.NewsViewModel

@Composable
fun NewsScreen(navController: NavController, viewModel: NewsViewModel) {
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