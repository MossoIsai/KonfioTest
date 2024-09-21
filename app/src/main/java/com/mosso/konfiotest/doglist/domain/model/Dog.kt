package com.mosso.konfiotest.doglist.domain.model

import com.mosso.konfiotest.core.data.source.local.DogEntity
import com.mosso.konfiotest.doglist.data.models.DogResponse


data class Dog(
    val name: String,
    val description: String,
    val age: Int,
    val imageUrl: String,
)

fun List<DogResponse>.toDomain(): List<Dog> =
    flatMap {
        arrayListOf(it.toDomain())
    }

fun DogResponse.toDomain(): Dog = Dog(
    name = name ?: "",
    description = description ?: "",
    age = age ?: 0,
    imageUrl = imageUrl ?: ""
)

fun List<DogEntity>.entityToDomain(): List<Dog> =
    flatMap {
        arrayListOf(it.toDomain())
    }

fun DogEntity.toDomain(): Dog = Dog(
    name = name,
    description = description,
    age = age,
    imageUrl = imageUrl
)

fun Dog.toData(): DogEntity = DogEntity(
    name = name,
    age = age,
    imageUrl = imageUrl,
    description = description,
)
