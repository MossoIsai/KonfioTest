package com.mosso.konfiotest.doglist.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mosso.konfiotest.core.data.source.local.DogEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DogDao {

    @Insert
    suspend fun insertUser(dog: DogEntity)

    @Query("SELECT * FROM dogentity")
    fun getAllDogList(): Flow<List<DogEntity>>
}