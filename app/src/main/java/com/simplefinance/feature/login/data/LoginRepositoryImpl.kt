package com.simplefinance.feature.login.data

import com.simplefinance.common.functional.Resource
import com.simplefinance.common.model.ErrorEntity
import com.simplefinance.feature.login.data.datasource.local.LoginDao
import com.simplefinance.feature.login.data.model.Login
import com.simplefinance.feature.login.domain.LoginRepository
import com.simplefinance.feature.news.data.model.News
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(val dao: LoginDao) : LoginRepository {
    lateinit var dataFlow: Flow<Resource<ErrorEntity, Login>>
    override suspend fun getData(): Flow<Resource<ErrorEntity, Login>> {
        dataFlow = channelFlow<Resource<ErrorEntity, Login>> {
            dao.get("1").collectLatest {
                if (it != null) {
                    send(Resource.Success(it))
                } else {
                    send(Resource.Error(ErrorEntity.NullObject))
                }
            }
        }
        return dataFlow
    }

    override suspend fun insert(pojo: Login) {
        dao.insert(pojo)
    }

}