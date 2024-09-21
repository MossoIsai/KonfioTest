package com.mosso.konfiotest.doglist.data.models

import com.google.gson.annotations.SerializedName

data class DogResponse(
    @SerializedName("dogName") val name: String? = null,
    @SerializedName("description") val description: String? = null,
    @SerializedName("age") val age: Int? = null,
    @SerializedName("image") val imageUrl: String? = null,
)
