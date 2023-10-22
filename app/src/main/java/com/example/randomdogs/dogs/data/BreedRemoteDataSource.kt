package com.example.randomdogs.dogs.data

import com.example.randomdogs.dogs.api.BreedApi
import javax.inject.Inject

class BreedRemoteDataSource @Inject constructor(private val api: BreedApi) {

	suspend fun get(): List<Breed> =
		api.get()
}