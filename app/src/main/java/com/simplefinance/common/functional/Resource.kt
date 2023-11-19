package com.simplefinance.common.functional

sealed class Resource<out L, out R> {
    data class Error<out L>(val error:L):Resource<L,Nothing>()
    data class Success<out R>(val success:R):Resource<Nothing,R>()

    val isSuccess get() = this is Success<R>
    val isError get() = this is Error<L>

    fun <R> success(b:R) = Success(b)
    fun <L> error(e:L) = Error(e)


}