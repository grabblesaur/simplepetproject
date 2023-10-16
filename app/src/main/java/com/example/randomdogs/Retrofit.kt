package com.example.randomdogs

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitManager {
	private const val BASE_URL = "https://api.thedogapi.com/v1/"
	private const val API_KEY = "live_NPhqzxfj0z2ve9f194RmKjJYKTKKMIjOGgpoujCYKjDH5R7cPavWrPLo8zfNSUlU"

	private fun getInterceptor(): Interceptor =
		Interceptor { chain ->
			val request = chain.request().newBuilder()
				.addHeader("x-api-key", API_KEY)
				.build()

			chain.proceed(request)
		}

	private fun getHttpClient(): OkHttpClient =
		OkHttpClient.Builder()
			.addInterceptor(getInterceptor())
			.build()

	val instance: Retrofit = Retrofit.Builder()
		.baseUrl(BASE_URL)
		.client(getHttpClient())
		.addConverterFactory(GsonConverterFactory.create())
		.build()
}