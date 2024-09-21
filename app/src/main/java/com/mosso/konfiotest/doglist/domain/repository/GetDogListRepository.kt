package com.mosso.konfiotest.doglist.domain.repository

import com.mosso.konfiotest.core.data.Result
import com.mosso.konfiotest.doglist.domain.model.Dog
import kotlinx.coroutines.flow.Flow

interface GetDogListRepository {

    suspend fun getDogList(): Flow<Result<List<Dog>>>

}