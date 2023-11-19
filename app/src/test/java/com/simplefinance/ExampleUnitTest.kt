package com.simplefinance

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import org.junit.After
import org.junit.Before
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    private lateinit var context: Context

    @Before
    fun pre(){
        context =  ApplicationProvider.getApplicationContext<Context>()

    }

    @After
    fun post(){

    }

    @Test
    fun addition_isCorrect() {

        println(getValue("Hello"))

        println(getValueLamda() {
                return@getValueLamda "Hello"
        })
    }

    fun getValue(append: String): String {
        return append + "Nishith"
    }

    fun getValueLamda(function: () -> String): String {
        return "Nishith" + function.invoke()
    }
}