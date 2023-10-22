package com.example.randomdogs.di.modules

import com.example.randomdogs.dogs.api.BreedApi
import com.example.randomdogs.dogs.api.ImageApi
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

	@Provides
	fun provideInterceptor(): Interceptor =
		Interceptor { chain ->
			val request = chain.request().newBuilder()
				.addHeader(
					"x-api-key",
					"live_NPhqzxfj0z2ve9f194RmKjJYKTKKMIjOGgpoujCYKjDH5R7cPavWrPLo8zfNSUlU"
				)
				.build()

			chain.proceed(request)
		}

	@Provides
	fun provideHttpClient(interceptor: Interceptor): OkHttpClient =
		OkHttpClient.Builder()
			.addInterceptor(interceptor)
			.build()

	@Provides
	fun provideRetrofit(httpClient: OkHttpClient): Retrofit =
		Retrofit.Builder()
			.baseUrl("https://api.thedogapi.com/v1/")
			.client(httpClient)
			.addConverterFactory(GsonConverterFactory.create())
			.build()

	@Provides
	fun provideBreedApi(retrofit: Retrofit): BreedApi =
		retrofit.create(BreedApi::class.java)

	@Provides
	fun provideImageApi(retrofit: Retrofit): ImageApi =
		retrofit.create(ImageApi::class.java)
}