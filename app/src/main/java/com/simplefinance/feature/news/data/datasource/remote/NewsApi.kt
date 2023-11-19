package com.simplefinance.feature.news.data.datasource.remote

import com.simplefinance.feature.news.data.datasource.NewsDataSource
import com.simplefinance.feature.news.data.model.News
import retrofit2.http.POST

interface NewsApi : NewsDataSource{
    @POST()
    override suspend fun insertNews(user: News)
}