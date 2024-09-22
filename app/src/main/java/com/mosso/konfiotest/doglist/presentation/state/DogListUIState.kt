package com.mosso.konfiotest.doglist.presentation.state

import com.mosso.konfiotest.doglist.domain.model.Dog

sealed interface DogListUIState {
    data object Loading : DogListUIState
    data class Error(val exception: String) : DogListUIState
    data class Success(val dogList: List<Dog>?) : DogListUIState
}