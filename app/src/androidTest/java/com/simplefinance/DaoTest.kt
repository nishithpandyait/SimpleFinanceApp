package com.simplefinance

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.simplefinance.feature.news.data.datasource.local.NewsDao
import com.simplefinance.feature.news.data.model.News
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

@RunWith(AndroidJUnit4::class)
@MediumTest
@HiltAndroidTest
@ExperimentalCoroutinesApi
class DaoTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var dao: NewsDao
    private var testDispatcher: TestDispatcher = StandardTestDispatcher()
    private var coroutineScope = CoroutineScope(testDispatcher)

    @Before
    fun preExecute() {
        hiltRule.inject()
    }

    @After
    fun postExecute() {

    }

    @Test
    fun testDaoConnection() {

        val handler = CoroutineExceptionHandler { _, exception ->
            println("CoroutineExceptionHandler got $exception")
        }
        runTest(testDispatcher) {
            coroutineScope.launch {
                val userDao = dao
                val async = async(handler) {
                    val news = News("INDIA VS AUS", "INDIA WON BY 2 WICKET")
                    userDao.insertNews(news)
                }
                async.await()
                val newsFlow = async(handler) {
                    return@async userDao.getLatestNews()
                }
                val await = newsFlow.await()
                val toList = await.toList()
                println("nish" + toList.toString())
                Assert.assertEquals(toList.isEmpty(), false)
            }
        }
    }
}