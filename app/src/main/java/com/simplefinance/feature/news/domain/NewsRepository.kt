package com.simplefinance.feature.news.domain

import com.simplefinance.common.functional.Resource
import com.simplefinance.common.model.ErrorEntity
import com.simplefinance.feature.news.data.model.News
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
   suspend fun getData(): Flow<Resource<ErrorEntity, News>>
    suspend fun insertNews(news: News)
}