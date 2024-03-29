package com.simplefinance.feature.login.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.simplefinance.R
import com.simplefinance.common.navigation.data.model.Screens
import com.simplefinance.common.ui.components.CTextField
import com.simplefinance.feature.login.presentation.model.LoginErrorUiState
import com.simplefinance.feature.login.presentation.model.LoginUiState
import com.simplefinance.feature.login.presentation.viewmodel.LoginViewModel
import com.simplefinance.ui.theme.spacing_medium
import com.simplefinance.ui.theme.spacing_small


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val uiData by viewModel.uiData.collectAsState()
    when (uiData) {
        is LoginUiState.SuccessUiState -> {
            Text(text = (uiData as LoginUiState.SuccessUiState).msg)
        }

        is LoginUiState.ErrorUiState -> {
            Text(text = (uiData as LoginUiState.ErrorUiState).error)
        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(spacing_medium)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null,
            modifier = Modifier
                .size(120.dp)
                .clip(shape = MaterialTheme.shapes.medium)
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = viewModel.email,
            onValueChange = { viewModel.email = it },
            placeholder = { Text(stringResource(R.string.email)) },
            leadingIcon = {
                Icon(
                    Icons.Outlined.MailOutline,
                    contentDescription = null,
                    modifier = Modifier.size(spacing_medium)
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(spacing_small)
        )

        Spacer(modifier = Modifier.height(spacing_medium))

        OutlinedTextField(
            value = viewModel.password,
            onValueChange = { viewModel.password = it },
            placeholder = { Text(stringResource(R.string.password)) },
            leadingIcon = {
                Icon(
                    Icons.Default.Key,
                    contentDescription = null,
                    modifier = Modifier.size(spacing_medium)
                )
            },
            trailingIcon = {
                IconButton(onClick = {
                    viewModel.isPasswordVisible = !viewModel.isPasswordVisible
                }) {
                    Icon(
                        imageVector = if (viewModel.isPasswordVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                        contentDescription = null,
                        modifier = Modifier.size(spacing_medium)
                    )
                }
            },
            visualTransformation = if (viewModel.isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    validateAndLogin(navController)
                }
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(spacing_small)
        )

        Spacer(modifier = Modifier.height(spacing_medium))

        Button(
            onClick = {
                validateAndLogin(navController)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(stringResource(R.string.login))
        }
    }
}

fun validateAndLogin(navController: NavController) {
    navController.popBackStack()
    navController.navigate(Screens.News.route)
}
