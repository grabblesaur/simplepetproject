package com.example.randomdogs.dogs.api

import com.example.randomdogs.RetrofitManager
import com.example.randomdogs.dogs.data.Image
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ImageApi {

	@Headers("x-api-key: ${RetrofitManager.API_KEY}")
	@GET("images/search")
	suspend fun get(
		@Query("limit") limit: Int = 9,
		@Query("breed_ids") breedId: String
	): List<Image>
}
