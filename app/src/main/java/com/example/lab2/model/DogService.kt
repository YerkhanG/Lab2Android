package com.example.lab2.model

import retrofit2.Call
import retrofit2.http.GET

interface DogService {
    @GET("v1/dogs?name=golden retriever")
    fun fetchOfferList() : Call<List<DogApi>>
}