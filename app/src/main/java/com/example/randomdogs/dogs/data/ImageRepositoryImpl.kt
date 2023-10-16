package com.example.randomdogs.dogs.data

import com.example.randomdogs.dogs.domain.ImageRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class ImageRepositoryImpl(
	private val imageDataSource: ImageDataSource,
	private val dispatcher: CoroutineDispatcher,
) : ImageRepository {

	override suspend fun get(breedId: String): List<Image> =
		withContext(dispatcher) {
			imageDataSource.get(breedId)
		}
}
