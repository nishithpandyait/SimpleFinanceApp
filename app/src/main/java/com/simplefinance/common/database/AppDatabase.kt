package com.simplefinance.common.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.simplefinance.feature.login.data.datasource.local.LoginDao
import com.simplefinance.feature.login.data.model.Login
import com.simplefinance.feature.news.data.datasource.local.NewsDao
import com.simplefinance.feature.news.data.model.News

@Database(entities = [News::class, Login::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getNewsDao(): NewsDao
    abstract fun getLoginDao(): LoginDao

}