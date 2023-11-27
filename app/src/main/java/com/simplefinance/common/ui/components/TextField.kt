package com.simplefinance.common.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.simplefinance.ui.theme.spacing_medium
import com.simplefinance.ui.theme.spacing_small

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CTextField(text: String, hint: String, onValueChange: (String) -> Unit) {
    Column(
        verticalArrangement = Arrangement.Center, modifier = Modifier
            .fillMaxSize()
            .padding(
                spacing_medium
            )
    ) {
        Text(text = hint)
        Spacer(modifier = Modifier.height(spacing_small))
        OutlinedTextField(value = text, onValueChange = onValueChange)
    }

}