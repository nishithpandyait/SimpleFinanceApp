package com.simplefinance.feature.news.data

import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito

@RunWith(JUnit4::class)
class NewsRepositoryImplTest {

    @MockK
    lateinit var newsRepositoryImpl: NewsRepositoryImpl

    private var testDispatcher: TestDispatcher = StandardTestDispatcher()
    private var coroutineScope = CoroutineScope(testDispatcher)

    @Before
    fun setUp() = runBlocking {

    }

    @Test
    fun testIsNull() = runBlocking{
        val result = Mockito.`when`(newsRepositoryImpl.getData()).then(null)
        assertEquals(result, null)
    }

    @After
    fun tearDown() {
    }
}