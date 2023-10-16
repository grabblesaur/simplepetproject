package com.example.randomdogs.dogs.api

import com.example.randomdogs.dogs.data.Image
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageApi {

	@GET("images/search")
	suspend fun get(
		@Query("limit") limit: Int = 9,
		@Query("breed_ids") breedId: String
	): List<Image>
}
