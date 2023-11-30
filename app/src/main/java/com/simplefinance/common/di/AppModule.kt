package com.simplefinance.common.di

import android.app.Activity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.simplefinance.R
import com.simplefinance.feature.login.data.datasource.local.LoginDao
import com.simplefinance.feature.login.data.LoginRepositoryImpl
import com.simplefinance.feature.login.domain.LoginRepository
import com.simplefinance.feature.login.domain.usecase.LoginUseCase
import com.simplefinance.feature.login.presentation.mapper.LoginMapper
import com.simplefinance.feature.news.data.NewsRepositoryImpl
import com.simplefinance.feature.news.data.datasource.local.NewsDao
import com.simplefinance.feature.news.domain.NewsRepository
import com.simplefinance.feature.news.domain.usecase.NewsUseCase
import com.simplefinance.feature.news.presentation.mapper.NewsMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(ActivityComponent::class)
class AppModule {
    @Provides
    fun provideNavController(activity: Activity): NavController {
        return activity.findNavController(androidx.navigation.R.id.nav_controller_view_tag)
    }
}