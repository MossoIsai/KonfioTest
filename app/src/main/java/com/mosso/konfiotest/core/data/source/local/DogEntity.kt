package com.mosso.konfiotest.core.data.source.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = TABLE_NAME)
data class DogEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    @ColumnInfo("name") val name: String,
    @ColumnInfo("description") val description: String,
    @ColumnInfo("age") val age: Int,
    @ColumnInfo("image_url") val imageUrl: String
)

const val TABLE_NAME = "dogentity"
