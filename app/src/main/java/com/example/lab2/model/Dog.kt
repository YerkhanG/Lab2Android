package com.example.lab2.model

data class Dog(
    val name: String,
    val minLifeExpectancy: Int,
    val maxLifeExpectancy: Int,
    val imageLink: String,
    val goodWithChildren: Int,
) {
    companion object {
        fun toDog(dogApi: DogApi) = Dog(
            name = dogApi.name,
            minLifeExpectancy = dogApi.minLifeExpectancy,
            maxLifeExpectancy = dogApi.maxLifeExpectancy,
            imageLink = dogApi.imageLink,
            goodWithChildren = dogApi.goodWithChildren


        )
    }
}