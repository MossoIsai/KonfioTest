package com.mosso.konfiotest.doglist.data.service

import com.mosso.konfiotest.doglist.data.models.DogResponse
import retrofit2.Response
import retrofit2.http.GET

interface DogListService {
    @GET("1151549092634943488")
    suspend fun getDogList(): Response<List<DogResponse>>
}