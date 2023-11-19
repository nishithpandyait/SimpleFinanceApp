package com.simplefinance

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.simplefinance.common.database.AppDatabase
import com.simplefinance.feature.news.data.model.News
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@MediumTest
class DaoTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var context: Context
    private lateinit var database: AppDatabase
    private var testDispatcher: TestDispatcher = UnconfinedTestDispatcher()



    @Before
    fun preExecute() {
        context = ApplicationProvider.getApplicationContext<Context>()
        database =
            Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).allowMainThreadQueries()
                .build()
    }

    @After
    fun postExecute() {
        database.close()
    }


    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testDaoConnection() {
        
        runTest(UnconfinedTestDispatcher()) {
            val userDao = database.getNewsDao()

            val news = News("INDIA VS AUS", "INDIA WON BY 2 WICKET")
            userDao.insertNews(news)

            val newsFlow = userDao.getLatestNews()
            val list: List<List<News>> = newsFlow.toList()

            Assert.assertEquals(list.flatten().contains(news), true)

        }
    }

}