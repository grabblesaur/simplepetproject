package com.example.randomdogs.dogs.api

import com.example.randomdogs.RetrofitManager
import com.example.randomdogs.dogs.data.Breed
import retrofit2.http.GET
import retrofit2.http.Headers

interface BreedApi {

	@Headers("x-api-key: ${RetrofitManager.API_KEY}")
	@GET("breeds?limit=10&page=0")
	suspend fun get(): List<Breed>
}