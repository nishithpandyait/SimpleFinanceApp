package com.simplefinance.common.functional

import com.simplefinance.common.model.ErrorEntity
import com.simplefinance.feature.news.data.model.News

interface ObjectMapper<F, T , M> {

    suspend fun map(f: Resource<ErrorEntity, M>): T

}