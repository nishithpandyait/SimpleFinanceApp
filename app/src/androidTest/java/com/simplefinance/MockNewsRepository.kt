package com.simplefinance

import com.simplefinance.common.functional.Resource
import com.simplefinance.common.model.ErrorEntity
import com.simplefinance.feature.news.data.model.News
import com.simplefinance.feature.news.domain.NewsRepository
import kotlinx.coroutines.flow.Flow

class MockNewsRepository : NewsRepository {
    override suspend fun getData(): Flow<Resource<ErrorEntity, News>> {
        TODO("Not yet implemented")
    }

    override suspend fun insertNews(news: News) {
        TODO("Not yet implemented")
    }
}