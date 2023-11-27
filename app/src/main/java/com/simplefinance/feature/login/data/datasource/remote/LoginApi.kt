package com.simplefinance.feature.login.data.datasource.remote

import com.simplefinance.feature.news.data.datasource.NewsDataSource
import com.simplefinance.feature.news.data.model.News
import retrofit2.http.POST

interface LoginApi : NewsDataSource{
    @POST()
    override suspend fun insertNews(user: News)
}