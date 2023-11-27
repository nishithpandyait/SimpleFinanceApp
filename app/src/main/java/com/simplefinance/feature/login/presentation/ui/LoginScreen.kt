package com.simplefinance.feature.login.presentation.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import com.simplefinance.common.ui.components.CTextField
import com.simplefinance.feature.login.presentation.model.LoginErrorUiState
import com.simplefinance.feature.login.presentation.model.LoginUiState
import com.simplefinance.feature.login.presentation.viewmodel.LoginViewModel


@Composable
fun LoginScreen(navController: NavController, viewModel: LoginViewModel) {
    val uiData by viewModel.uiData.collectAsState()
    when (uiData) {
        is LoginUiState.SuccessUiState -> {
            Text(text = (uiData as LoginUiState.SuccessUiState).msg)
        }
        is LoginUiState.ErrorUiState -> {
            Text(text = (uiData as LoginUiState.ErrorUiState).error)
        }
    }
}