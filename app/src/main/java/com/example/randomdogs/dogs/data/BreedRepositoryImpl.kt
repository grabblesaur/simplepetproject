package com.example.randomdogs.dogs.data

import com.example.randomdogs.dogs.domain.BreedRepository

class BreedRepositoryImpl(
	private val breedRemoteDataSource: BreedRemoteDataSource,
) : BreedRepository {

	override fun get(): List<Breed> =
		breedRemoteDataSource.get()
}