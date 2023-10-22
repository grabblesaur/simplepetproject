package com.example.randomdogs.dogs.data

import com.example.randomdogs.dogs.api.ImageApi
import javax.inject.Inject

class ImageDataSource @Inject constructor(private val api: ImageApi) {

	suspend fun get(breedId: String): List<Image> =
		api.get(breedId = breedId)
}
