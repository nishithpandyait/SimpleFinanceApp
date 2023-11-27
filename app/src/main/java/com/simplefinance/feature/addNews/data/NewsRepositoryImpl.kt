package com.simplefinance.feature.addNews.data

import com.simplefinance.common.functional.Resource
import com.simplefinance.common.model.ErrorEntity
import com.simplefinance.feature.news.data.datasource.local.NewsDao
import com.simplefinance.feature.news.data.model.News
import com.simplefinance.feature.news.domain.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(val newsDao: NewsDao) : NewsRepository {

    lateinit var dataFlow: Flow<Resource<ErrorEntity, News>>

    override suspend fun getData(): Flow<Resource<ErrorEntity, News>> {
        dataFlow = channelFlow<Resource<ErrorEntity, News>> {
            newsDao.getNews("1").collectLatest {
                if (it != null) {
                    send(Resource.Success(it))
                } else {
                    send(Resource.Error(ErrorEntity.NullObject))
                }
            }
        }
        return dataFlow
    }

    override suspend fun insertNews(pojo: News) {
        newsDao.insertNews(pojo)
    }

}