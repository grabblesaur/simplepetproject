package com.example.randomdogs

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitManager {
	private const val BASE_URL = "https://api.thedogapi.com/v1/"
	const val API_KEY = "live_NPhqzxfj0z2ve9f194RmKjJYKTKKMIjOGgpoujCYKjDH5R7cPavWrPLo8zfNSUlU"

	val instance: Retrofit = Retrofit.Builder()
		.baseUrl(BASE_URL)
		.addConverterFactory(GsonConverterFactory.create())
		.build()
}