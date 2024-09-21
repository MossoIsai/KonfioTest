package com.mosso.konfiotest.core.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mosso.konfiotest.doglist.data.source.local.DogDao

@Database(
    entities = [DogEntity::class],
    version = 1,
    exportSchema = false
)

abstract class DogDatabase : RoomDatabase() {
    abstract fun dogDao(): DogDao
}