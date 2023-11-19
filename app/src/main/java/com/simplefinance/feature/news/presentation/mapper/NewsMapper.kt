package com.simplefinance.feature.news.presentation.mapper

import com.simplefinance.common.functional.ObjectMapper
import com.simplefinance.common.functional.Resource
import com.simplefinance.common.model.ErrorEntity
import com.simplefinance.common.ui.BaseUiModel
import com.simplefinance.feature.news.data.model.News
import com.simplefinance.feature.news.presentation.model.UserUiError
import com.simplefinance.feature.news.presentation.model.UserUiModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

class NewsMapper : ObjectMapper<Resource<ErrorEntity, News>, BaseUiModel> {

    override suspend fun map(f: Resource<ErrorEntity, News>): BaseUiModel =
        CoroutineScope(Dispatchers.Default).async {
            val baseUiModel: BaseUiModel = when (f) {
                is Resource.Success -> {
                    UserUiModel(f.success.title + f.success.description)
                }

                is Resource.Error -> {
                    UserUiError(f.error.reason)
                }
            }
            return@async baseUiModel
        }.await()
}