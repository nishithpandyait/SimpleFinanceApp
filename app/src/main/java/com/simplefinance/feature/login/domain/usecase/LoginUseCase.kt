package com.simplefinance.feature.login.domain.usecase

import com.simplefinance.common.functional.Resource
import com.simplefinance.common.model.ErrorEntity
import com.simplefinance.feature.login.data.model.Login
import com.simplefinance.feature.login.domain.LoginRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoginUseCase @Inject constructor(val repository: LoginRepository) {
    suspend operator fun invoke(): Flow<Resource<ErrorEntity, Login>> {
        return withContext(Dispatchers.IO) {
            repository.getData()
        }
    }

    suspend fun insertNews(pojo: Login) {
        withContext(Dispatchers.IO) {
            repository.insert(news = pojo)
        }
    }
}