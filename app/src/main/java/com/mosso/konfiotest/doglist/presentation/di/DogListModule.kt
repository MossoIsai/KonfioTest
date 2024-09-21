package com.mosso.konfiotest.doglist.presentation.di

import com.mosso.konfiotest.doglist.data.repository.GetDogListRepositoryImp
import com.mosso.konfiotest.doglist.domain.repository.GetDogListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DogListModule {

    @Binds
    fun moviesRepository(repository: GetDogListRepositoryImp): GetDogListRepository
}