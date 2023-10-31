package com.example.randomdogs.dogs.api

import com.example.randomdogs.dogs.data.Breed
import retrofit2.http.GET
import retrofit2.http.Query

interface BreedApi {

	@GET("breeds?limit=10")
	suspend fun get(@Query("page") page: Int): List<Breed>
}