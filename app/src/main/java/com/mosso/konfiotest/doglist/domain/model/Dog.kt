package com.mosso.konfiotest.doglist.domain.model

import com.mosso.konfiotest.doglist.data.models.DogListResponse
import com.mosso.konfiotest.doglist.data.models.DogResponse


data class DogListDomain(
    val dogList: List<Dog>
)

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
