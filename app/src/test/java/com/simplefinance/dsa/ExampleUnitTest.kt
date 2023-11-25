package com.simplefinance.dsa

import org.junit.Assert
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    val localDB = mutableListOf<Int>(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val arrayToRemove = mutableListOf<Int>(0, 5, 7)
    val api: RetrofitApi = RetrofitApi()


    @Test
    fun apiTest() {
        val iterator = localDB.iterator()
        while (iterator.hasNext()) {
            val i = iterator.next()
            if (localDB.contains(i) && localDB.containsAll(arrayToRemove)) {
                iterator.remove()
                arrayToRemove.remove(i)
                api.removeElementApi(i)
            }
        }
        printLocalData()
        api.printData()
        val remoteDatabase = api.getRemoteDatabase()
        Assert.assertEquals(remoteDatabase.containsAll(localDB), true)
    }

    private fun printLocalData() {

    }

}