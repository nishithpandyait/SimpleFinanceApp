package com.simplefinance.feature.login.presentation.mapper

import com.simplefinance.common.functional.ObjectMapper
import com.simplefinance.common.functional.Resource
import com.simplefinance.common.model.ErrorEntity
import com.simplefinance.common.ui.BaseUiModel
import com.simplefinance.feature.login.data.model.Login
import com.simplefinance.feature.login.presentation.model.LoginUiState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

class LoginMapper : ObjectMapper<Resource<ErrorEntity, Login>, BaseUiModel, Login> {

    override suspend fun map(f: Resource<ErrorEntity, Login>): BaseUiModel =
        CoroutineScope(Dispatchers.Default).async {
            val baseUiModel: BaseUiModel = when (f) {
                is Resource.Success -> {
                    LoginUiState.SuccessUiState(f.success.name)
                }
                is Resource.Error -> {
                    LoginUiState.ErrorUiState(f.error.reason)
                }
            }
            return@async baseUiModel
        }.await()
}