package com.example.randomdogs.dogs.domain

import com.example.randomdogs.dogs.data.Image

class GetImageListUseCase(private val imageRepository: ImageRepository) {

	suspend fun get(breedId: String): List<Image> =
		imageRepository.get(breedId)
}
