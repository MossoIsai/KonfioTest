package com.mosso.konfiotest.doglist.data.repository

import com.mosso.konfiotest.core.domain.ServiceFactory
import com.mosso.konfiotest.doglist.data.service.DogListService
import com.mosso.konfiotest.doglist.domain.repository.GetDogListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import com.mosso.konfiotest.core.data.Result
import com.mosso.konfiotest.doglist.data.models.DogResponse
import javax.inject.Inject


class GetDogListRepositoryImp @Inject constructor(
    serviceFactory: ServiceFactory
) : GetDogListRepository {

    private val service = serviceFactory.makeConnectionApiService(DogListService::class.java)

    override suspend fun getDogList(): Flow<Result<List<DogResponse>>> {
        return flow {
            val response = service.getDogList()
            if (response.isSuccessful) {
                emit(Result.Success(response.body()))
            } else {
                emit(Result.Error(Throwable("Failed")))
            }
        }.catch {
            emit(Result.Error(it))
        }
    }
}