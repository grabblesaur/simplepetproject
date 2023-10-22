package com.example.randomdogs.dogs.domain

import com.example.randomdogs.dogs.data.Breed
import javax.inject.Inject

class GetBreedListUseCase @Inject constructor(
	private val breedRepository: BreedRepository,
) {

	suspend operator fun invoke(): List<Breed> =
		breedRepository.get()
}