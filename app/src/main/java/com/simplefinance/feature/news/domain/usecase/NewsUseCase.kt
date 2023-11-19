package com.simplefinance.feature.news.domain.usecase

import com.simplefinance.common.functional.Resource
import com.simplefinance.common.model.ErrorEntity
import com.simplefinance.feature.news.data.model.News
import com.simplefinance.feature.news.domain.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NewsUseCase @Inject constructor(private val repository: NewsRepository) {
    suspend operator fun invoke(): Flow<Resource<ErrorEntity, News>> {
        return withContext(Dispatchers.IO) {
            repository.getData()
        }
    }

    suspend fun insertNews(news: News) {
        withContext(Dispatchers.IO){
            repository.insertNews(news = news)
        }
    }
}