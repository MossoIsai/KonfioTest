package com.mosso.konfiotest.doglist.data.repository

import android.util.Log
import com.mosso.konfiotest.core.domain.ServiceFactory
import com.mosso.konfiotest.doglist.data.source.remote.DogListService
import com.mosso.konfiotest.doglist.domain.repository.GetDogListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import com.mosso.konfiotest.core.data.Result
import com.mosso.konfiotest.core.data.source.local.DogEntity
import com.mosso.konfiotest.doglist.data.source.local.DogDao
import com.mosso.konfiotest.doglist.domain.model.Dog
import com.mosso.konfiotest.doglist.domain.model.entityToDomain
import com.mosso.konfiotest.doglist.domain.model.toData
import com.mosso.konfiotest.doglist.domain.model.toDomain
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class GetDogListRepositoryImp @Inject constructor(
    serviceFactory: ServiceFactory,
    private val dao: DogDao
) : GetDogListRepository {

    private val service = serviceFactory.makeConnectionApiService(DogListService::class.java)

    override suspend fun getDogList(): Flow<Result<List<Dog>>> {
        return flow<Result<List<Dog>>> {
            val daoFlow: Flow<List<DogEntity>> = dao.getAllDogList()
            daoFlow.collect { dogListEntity ->
                if (dogListEntity.isEmpty()) {
                    val response = service.getDogList()
                    if (response.isSuccessful) {
                        response.body()?.toDomain()?.forEach { item ->
                            dao.insertUser(item.toData())
                        }
                        emit(Result.Success(response.body()?.toDomain()))
                    } else {
                        emit(Result.Error(Throwable(response.message())))
                    }
                } else {
                    emit(Result.Success(dogListEntity.entityToDomain()))
                }
            }
        }.catch {
            emit(Result.Error(it))
            emit(Result.Success(emptyList()))
        }
    }
}