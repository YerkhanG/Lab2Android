package com.example.lab2.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DogService {
    @GET("v1/dogs")
    fun fetchOfferList(@Query("name")  name :String): Call<List<DogApi>>
}