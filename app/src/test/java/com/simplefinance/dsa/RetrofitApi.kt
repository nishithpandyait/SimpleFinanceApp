package com.simplefinance.dsa

class RetrofitApi {
    //server
    val remoteDB = mutableListOf<Int>(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    fun removeElementApi(int: Int) {
        remoteDB.remove(int)
    }

    fun printData() {
        println(remoteDB.toString())
    }

    fun getRemoteDatabase(): MutableList<Int> {
        return remoteDB
    }
}