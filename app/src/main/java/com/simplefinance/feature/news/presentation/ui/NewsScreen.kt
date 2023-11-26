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
import com.simplefinance.feature.news.presentation.model.UserUiError
import com.simplefinance.feature.news.presentation.model.UserUiModel
import com.simplefinance.feature.news.presentation.viewmodel.NewsViewModel

@Composable
fun NewsScreen(navController: NavController, viewModel: NewsViewModel) {
    val uiData by viewModel.uiData.collectAsState()

    IconButton(onClick = {}) {
        Icon(
            imageVector = Icons.Filled.Share,
            contentDescription = "Hello"
        )
    }

    when (uiData) {
        is UserUiModel -> {
            Text(text = (uiData as UserUiModel).name)
        }

        is UserUiError -> {
            Text(text = (uiData as UserUiError).error)
        }
    }
}