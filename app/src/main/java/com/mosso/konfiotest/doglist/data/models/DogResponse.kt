package com.mosso.konfiotest.doglist.data.models

import com.google.gson.annotations.SerializedName
import com.mosso.konfiotest.core.data.source.local.DogEntity

data class DogResponse(
    @SerializedName("dogName") val name: String? = null,
    @SerializedName("description") val description: String? = null,
    @SerializedName("age") val age: Int? = null,
    @SerializedName("image") val imageUrl: String? = null,
)

fun DogEntity.toResponse(): DogResponse = DogResponse(
    name = name,
    description = description,
    age = age,
    imageUrl = imageUrl
)

fun List<DogEntity>.toResponse(): List<DogResponse> =
    flatMap {
        arrayListOf(it.toResponse())
    }
