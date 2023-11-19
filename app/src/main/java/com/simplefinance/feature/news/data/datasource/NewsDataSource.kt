package com.simplefinance.feature.news.data.datasource

import com.simplefinance.feature.news.data.model.News
import kotlinx.coroutines.flow.Flow

interface NewsDataSource {
    suspend fun insertNews(user: News)
    fun getNews(id: String):Flow<News>
    fun getLatestNews(): Flow<List<News>>
}