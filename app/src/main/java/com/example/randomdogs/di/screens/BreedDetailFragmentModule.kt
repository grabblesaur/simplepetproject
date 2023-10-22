package com.example.randomdogs.di.screens

import com.example.randomdogs.di.modules.DispatcherModule
import com.example.randomdogs.di.modules.NetworkModule
import com.example.randomdogs.dogs.data.ImageRepositoryImpl
import com.example.randomdogs.dogs.domain.ImageRepository
import dagger.Binds
import dagger.Module

@Module(includes = [NetworkModule::class, DispatcherModule::class])
interface BreedDetailFragmentModule {

	@Binds
	fun bindImageRepository(impl: ImageRepositoryImpl): ImageRepository
}