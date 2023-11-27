package com.simplefinance.feature.login.domain

import com.simplefinance.common.functional.Resource
import com.simplefinance.common.model.ErrorEntity
import com.simplefinance.feature.login.data.model.Login
import com.simplefinance.feature.news.data.model.News
import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    suspend fun getData(): Flow<Resource<ErrorEntity, Login>>
    suspend fun insert(news: Login)
}