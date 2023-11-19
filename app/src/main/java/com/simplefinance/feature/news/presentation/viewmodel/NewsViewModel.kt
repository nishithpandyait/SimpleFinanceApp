package com.simplefinance.feature.news.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.simplefinance.common.model.ErrorEntity
import com.simplefinance.common.ui.BaseUiModel
import com.simplefinance.feature.news.data.model.News
import com.simplefinance.feature.news.domain.usecase.NewsUseCase
import com.simplefinance.feature.news.presentation.mapper.NewsMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch

import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(var newsUseCase: NewsUseCase, var dataMapper: NewsMapper) :
    ViewModel() {

    private val _uiData: MutableStateFlow<BaseUiModel> = MutableStateFlow<BaseUiModel>(BaseUiModel())
    val uiData: MutableStateFlow<BaseUiModel> = _uiData

    init {
        insertNews()
        getData()
    }

    fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = newsUseCase.invoke()
            result.catch {
                uiData.emit(dataMapper.map(ErrorEntity.getInstance(it.message!!)))
            }.collect() {
                uiData.emit(dataMapper.map(it))
            }
        }
    }

    fun insertNews() {
        viewModelScope.launch {
            newsUseCase.insertNews(News("job", "description"))
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}