package com.example.randomdogs.dogs.domain

import com.example.randomdogs.dogs.data.Breed

class GetBreedListUseCase(
	private val breedRepository: BreedRepository,
) {

	suspend operator fun invoke(): List<Breed> =
		breedRepository.get()
}