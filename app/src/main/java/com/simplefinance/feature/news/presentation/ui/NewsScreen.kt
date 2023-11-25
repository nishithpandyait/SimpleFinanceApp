package com.simplefinance.feature.news.presentation.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import com.simplefinance.feature.news.presentation.model.UserUiError
import com.simplefinance.feature.news.presentation.model.UserUiModel
import com.simplefinance.feature.news.presentation.viewmodel.NewsViewModel

@Composable
fun NewsScreen(navController: NavController, viewModel: NewsViewModel) {
    val collectAsState by viewModel.uiData.collectAsState()
    when (collectAsState) {
        is UserUiModel -> {
            Text(text = (collectAsState as UserUiModel).name)
        }

        is UserUiError -> {
            Text(text = collectAsState.error)
        }
    }
}