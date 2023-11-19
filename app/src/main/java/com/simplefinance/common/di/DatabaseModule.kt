package com.simplefinance.common.di

import android.content.Context
import androidx.room.Room
import com.simplefinance.common.database.AppDatabase
import com.simplefinance.feature.news.data.datasource.local.NewsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun getDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java, "app-database"
        ).build()
    }

    @Provides
    fun getUserDao(appDatabase: AppDatabase): NewsDao {
        return appDatabase.getNewsDao()
    }
}