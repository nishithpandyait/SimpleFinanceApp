package com.simplefinance.feature.news.data.datasource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.simplefinance.feature.news.data.datasource.NewsDataSource
import com.simplefinance.feature.news.data.model.News
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao : NewsDataSource {
    @Insert
    override suspend fun insertNews(pojo: News)

    @Query("select * from news where uid = :uid")
    override fun getNews(uid: String): Flow<News>

    @Query("select * from news")
    override fun getLatestNews(): Flow<List<News>>

}