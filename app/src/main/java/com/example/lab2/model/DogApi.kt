package com.example.lab2.model

import com.google.gson.annotations.SerializedName

data class DogApi (
    val id : String ,
    val name : String,
    @SerializedName("min_life_expectancy") val minLifeExpectancy : Int ,
    @SerializedName("max_life_expectancy") val maxLifeExpectancy : Int ,
    @SerializedName("image_link") val imageLink : String ,
    @SerializedName("good_with_children") val goodWithChildren : Int ,
)