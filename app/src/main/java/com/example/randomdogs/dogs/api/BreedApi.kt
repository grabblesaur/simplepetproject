package com.example.randomdogs.dogs.api

import com.example.randomdogs.dogs.data.Breed
import retrofit2.http.GET

interface BreedApi {

	@GET("breeds?limit=10&page=0")
	suspend fun get(): List<Breed>
}