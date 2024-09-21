package com.mosso.konfiotest.doglist.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mosso.konfiotest.doglist.domain.GetDogListUseCase
import com.mosso.konfiotest.doglist.presentation.state.DogListUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject
import com.mosso.konfiotest.core.data.Result

@HiltViewModel
class DogListViewModel @Inject constructor(
    useCase: GetDogListUseCase
) : ViewModel() {

    val dogListUIState: StateFlow<DogListUIState> =
        useCase.execute().map {
            when (it) {
                is Result.Error -> DogListUIState.Error(it.exception)
                is Result.Success -> if (it.body?.isNotEmpty() == true) {
                    DogListUIState.Success(it.body)
                } else {
                    DogListUIState.EmptyState
                }
            }
        }.catch {
            DogListUIState.Error(it)
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = DogListUIState.Loading
        )
}