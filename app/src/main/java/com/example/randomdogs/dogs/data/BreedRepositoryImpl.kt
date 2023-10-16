package com.example.randomdogs.dogs.data

import com.example.randomdogs.dogs.domain.BreedRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BreedRepositoryImpl(
	private val breedRemoteDataSource: BreedRemoteDataSource,
	private val dispatcher: CoroutineDispatcher
) : BreedRepository {

	override suspend fun get(): List<Breed> =
		withContext(dispatcher) {
			breedRemoteDataSource.get()
		}
}