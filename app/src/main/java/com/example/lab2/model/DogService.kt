package com.example.lab2.model

import retrofit2.Call
import retrofit2.http.GET

interface DogService {
    @GET("dogs?name=dog")
    fun fetchOfferList() : Call<List<DogApi>>
}