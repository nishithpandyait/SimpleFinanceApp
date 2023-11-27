package com.simplefinance.feature.login.data.datasource

import com.simplefinance.feature.login.data.model.Login
import com.simplefinance.feature.news.data.model.News
import kotlinx.coroutines.flow.Flow

interface LoginDataSource {
    suspend fun insert(user: Login)
    fun get(id: String):Flow<Login>
    fun getLatest(): Flow<List<Login>>
}