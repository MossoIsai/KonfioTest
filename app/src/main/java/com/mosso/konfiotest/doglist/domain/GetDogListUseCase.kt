package com.mosso.konfiotest.doglist.domain

import com.mosso.konfiotest.core.data.Result
import com.mosso.konfiotest.core.domain.usecase.BaseUseCase
import com.mosso.konfiotest.core.presentation.CoreModule.IoDispatcher
import com.mosso.konfiotest.doglist.domain.model.Dog
import com.mosso.konfiotest.doglist.domain.repository.GetDogListRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetDogListUseCase @Inject constructor(
    private val repository: GetDogListRepository,
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
) : BaseUseCase<Unit, Result<List<Dog>>>() {

    override fun execute(params: Unit): Flow<Result<List<Dog>>> =
        flow<Result<List<Dog>>> {
            repository.getDogList().collect {
                when (it) {
                    is Result.Error -> {
                        emit(Result.Error(it.exception))
                    }
                    is Result.Success -> emit(Result.Success(it.body))
                }
            }
        }.flowOn(dispatcher)
}