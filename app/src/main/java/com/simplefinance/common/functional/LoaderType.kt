package com.simplefinance.common.functional

sealed class LoaderType{
    class DefaultLoader: LoaderType()
    class ShimmerLoader: LoaderType()
}
