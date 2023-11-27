package com.simplefinance.feature.login.presentation.model

import com.simplefinance.common.ui.BaseUiModel

class LoginUiState() : BaseUiModel() {
    data class SuccessUiState(val msg: String) : BaseUiModel()
    data class ErrorUiState(val err: String) : BaseUiModel(err)
}