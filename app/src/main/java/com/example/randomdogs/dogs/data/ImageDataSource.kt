package com.example.randomdogs.dogs.data

import com.example.randomdogs.dogs.api.ImageApi

class ImageDataSource(private val api: ImageApi) {

	suspend fun get(breedId: String): List<Image> =
		api.get(breedId = breedId)
}
