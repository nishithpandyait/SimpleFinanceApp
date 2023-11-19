package com.simplefinance.common.model

import com.simplefinance.common.functional.Resource

open class ErrorEntity(val reason: String) : IEvent() {

    object NetworkConnection : ErrorEntity("Network Unavailable")
    object AccessDenied : ErrorEntity("Login Expired.")
    object ServiceUnavailable : ErrorEntity("Service Unavailable")
    object NullObject : ErrorEntity("Record Not Found")
    class CustomLog(private val log: String) : ErrorEntity(log)

    companion object{
        fun getInstance(message:String) = Resource.Error(CustomLog(message))
    }
}