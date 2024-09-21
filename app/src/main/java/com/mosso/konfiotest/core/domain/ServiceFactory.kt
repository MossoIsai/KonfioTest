package com.mosso.konfiotest.core.domain

interface ServiceFactory {
    fun <T> makeConnectionApiService(serviceClass: Class<T>): T
}