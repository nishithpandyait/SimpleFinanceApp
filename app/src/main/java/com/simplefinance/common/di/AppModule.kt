package com.simplefinance.common.di

import com.simplefinance.feature.news.data.NewsRepositoryImpl
import com.simplefinance.feature.news.data.datasource.local.NewsDao
import com.simplefinance.feature.news.domain.NewsRepository
import com.simplefinance.feature.news.domain.usecase.NewsUseCase
import com.simplefinance.feature.news.presentation.mapper.NewsMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun getUserRepository(newsDao: NewsDao): NewsRepository {
        return NewsRepositoryImpl(newsDao)
    }

    @Provides
    fun getUserMapper(): NewsMapper {
        return NewsMapper()
    }

    @Provides
    fun getNewsUseCase(newsDao: NewsDao): NewsUseCase {
        return NewsUseCase(getUserRepository(newsDao = newsDao))
    }


}