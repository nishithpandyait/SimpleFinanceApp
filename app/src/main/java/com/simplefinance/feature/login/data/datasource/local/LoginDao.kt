package com.simplefinance.feature.login.data.datasource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.simplefinance.feature.login.data.datasource.LoginDataSource
import com.simplefinance.feature.login.data.model.Login
import com.simplefinance.feature.news.data.datasource.NewsDataSource
import kotlinx.coroutines.flow.Flow

@Dao
interface LoginDao : LoginDataSource {
    @Insert
    override suspend fun insert(pojo: Login)

    @Query("select * from login where uid = :uid")
    override fun get(uid: String): Flow<Login>

    @Query("select * from login")
    override fun getLatest(): Flow<List<Login>>

}