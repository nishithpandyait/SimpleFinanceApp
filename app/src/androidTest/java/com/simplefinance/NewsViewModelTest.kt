package com.simplefinance

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.simplefinance.feature.news.domain.usecase.NewsUseCase
import com.simplefinance.feature.news.presentation.mapper.NewsMapper
import com.simplefinance.feature.news.presentation.viewmodel.NewsViewModel
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

@RunWith(AndroidJUnit4::class)
@MediumTest
@HiltAndroidTest
@ExperimentalCoroutinesApi
class NewsViewModelTest {

    @Inject
    lateinit var mapper: NewsMapper

    @Inject
    lateinit var useCase: NewsUseCase
    lateinit var viewModel: NewsViewModel


    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun setup() {
        hiltRule.inject()
        viewModel = NewsViewModel(useCase, mapper)
    }
    @Test
    fun checkViewModelNotNull() {
        assertNotNull(viewModel)
    }

}