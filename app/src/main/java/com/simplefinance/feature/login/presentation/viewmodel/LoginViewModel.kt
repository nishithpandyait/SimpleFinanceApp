package com.simplefinance.feature.login.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.simplefinance.common.model.ErrorEntity
import com.simplefinance.common.ui.BaseUiModel
import com.simplefinance.feature.login.data.model.Login
import com.simplefinance.feature.login.domain.usecase.LoginUseCase

import com.simplefinance.feature.login.presentation.mapper.LoginMapper
import com.simplefinance.feature.login.presentation.model.LoginErrorUiState
import com.simplefinance.feature.login.presentation.model.LoginUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch

import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(var useCase: LoginUseCase, var dataMapper: LoginMapper) : ViewModel() {

    private val _uiData: MutableStateFlow<BaseUiModel> =
        MutableStateFlow<BaseUiModel>(BaseUiModel(""))
    val uiData: MutableStateFlow<BaseUiModel> = _uiData

    init {
        insertNews()
        getData()
    }

    fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = useCase.invoke()
            result.catch {
                uiData.emit(dataMapper.map(ErrorEntity.getInstance(it.message!!)))
            }.collect() {
                uiData.emit(dataMapper.map(it))
            }
        }
    }

    fun insertNews() {
        viewModelScope.launch {
            useCase.insertNews(Login("new login"))
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}