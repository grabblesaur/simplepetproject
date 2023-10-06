package com.example.randomdogs.dogs.domain

import com.example.randomdogs.dogs.data.Image

interface ImageRepository {

	suspend fun get(breedId: String): List<Image>
}
