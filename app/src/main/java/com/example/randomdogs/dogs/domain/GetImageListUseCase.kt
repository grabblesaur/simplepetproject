package com.example.randomdogs.dogs.domain

import com.example.randomdogs.dogs.data.Image

class GetImageListUseCase(private val imageRepository: ImageRepository) {

	suspend operator fun invoke(breedId: String): List<Image> =
		imageRepository.get(breedId)
}
