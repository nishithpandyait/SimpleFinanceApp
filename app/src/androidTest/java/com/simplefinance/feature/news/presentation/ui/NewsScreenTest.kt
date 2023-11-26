package com.simplefinance.feature.news.presentation.ui

import androidx.activity.compose.setContent
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assertAny
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.navigation.NavController
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.simplefinance.MainActivity
import com.simplefinance.feature.news.domain.usecase.NewsUseCase
import com.simplefinance.feature.news.presentation.mapper.NewsMapper
import com.simplefinance.feature.news.presentation.viewmodel.NewsViewModel
import com.simplefinance.ui.theme.SimpleFinanceAppTheme
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import io.mockk.MockKAnnotations.init
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

@RunWith(AndroidJUnit4::class)
@MediumTest
@HiltAndroidTest
@ExperimentalCoroutinesApi
class NewsScreenTest {
    lateinit var context: HiltTestApplication


    lateinit var mockedViewModel: NewsViewModel

    @RelaxedMockK
    lateinit var mockedNavController: NavController

    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    @get:Rule
    val hiltAndroidTest = HiltAndroidRule(this)

    @Inject
    lateinit var mapper: NewsMapper

    @Inject
    lateinit var useCase: NewsUseCase


    @Before
    fun before() {
        init(this)
        hiltAndroidTest.inject()
        mockedViewModel = NewsViewModel(useCase, mapper)
        context = ApplicationProvider.getApplicationContext<HiltTestApplication>()
    }

    @Test
    fun testSplashScreen() = runTest() {

        composeRule.activity.setContent {
            SimpleFinanceAppTheme {
                NewsScreen(navController = mockedNavController, viewModel = mockedViewModel)
            }
        }
        composeRule.onAllNodesWithText("jobdescription")
            .assertAny(SemanticsMatcher("jobdescription") { true })
        /*verify {
            mockedViewModel.getData()
        }*/
    }

}