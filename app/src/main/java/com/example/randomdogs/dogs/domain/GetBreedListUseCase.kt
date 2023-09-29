package com.example.randomdogs.dogs.domain

import com.example.randomdogs.dogs.data.Breed

class GetBreedListUseCase(
	private val breedRepository: BreedRepository,
) {

	suspend fun get(): List<Breed> =
		breedRepository.get()
}