package com.simplefinance.feature.login.di

import com.simplefinance.feature.login.data.LoginRepositoryImpl
import com.simplefinance.feature.login.data.datasource.local.LoginDao
import com.simplefinance.feature.login.domain.LoginRepository
import com.simplefinance.feature.login.domain.usecase.LoginUseCase
import com.simplefinance.feature.login.presentation.mapper.LoginMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class LoginModule {
    @Provides
    fun getLoginRepository(dao: LoginDao): LoginRepository {
        return LoginRepositoryImpl(dao)
    }

    @Provides
    fun getLoginMapper(): LoginMapper {
        return LoginMapper()
    }

    @Provides
    fun getLoginUseCase(loginDao: LoginDao): LoginUseCase {
        return LoginUseCase(getLoginRepository(dao = loginDao))
    }
}