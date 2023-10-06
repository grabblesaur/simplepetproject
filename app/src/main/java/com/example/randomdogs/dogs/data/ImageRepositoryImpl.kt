package com.example.randomdogs.dogs.data

import com.example.randomdogs.dogs.domain.ImageRepository

class ImageRepositoryImpl(private val imageDataSource: ImageDataSource) : ImageRepository {

	override suspend fun get(breedId: String): List<Image> =
		imageDataSource.get(breedId)
}
