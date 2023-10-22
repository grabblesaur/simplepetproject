package com.example.randomdogs.di.screens

import com.example.randomdogs.di.modules.DispatcherModule
import com.example.randomdogs.di.modules.NetworkModule
import com.example.randomdogs.dogs.data.BreedRepositoryImpl
import com.example.randomdogs.dogs.domain.BreedRepository
import dagger.Binds
import dagger.Module

@Module(
	includes = [
		NetworkModule::class,
		DispatcherModule::class
	]
)
interface BreedsFragmentModule {

	@Binds
	fun bindBreedRepository(impl: BreedRepositoryImpl): BreedRepository
}