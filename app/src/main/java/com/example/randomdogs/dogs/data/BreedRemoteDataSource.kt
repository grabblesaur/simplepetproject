package com.example.randomdogs.dogs.data

import com.example.randomdogs.dogs.api.BreedApi

interface BreedRemoteDataSource {

	suspend fun get(): List<Breed>
}

class BreedRemoteDataSourceImpl(
	private val api: BreedApi,
) : BreedRemoteDataSource {

	override suspend fun get(): List<Breed> =
		api.get()
}