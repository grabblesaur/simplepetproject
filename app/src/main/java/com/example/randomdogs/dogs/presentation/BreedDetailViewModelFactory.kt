package com.example.randomdogs.dogs.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.randomdogs.dogs.data.Breed
import com.example.randomdogs.dogs.domain.GetImageListUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

@Suppress("UNCHECKED_CAST")
class BreedDetailViewModelFactory @AssistedInject constructor(
	@Assisted("breed") private val breed: Breed,
	private val getImageListUseCase: GetImageListUseCase,
) : ViewModelProvider.Factory {

	override fun <T : ViewModel> create(modelClass: Class<T>): T {
		require(modelClass == BreedDetailViewModel::class.java)
		return BreedDetailViewModel(breed, getImageListUseCase) as T
	}

	@AssistedFactory
	interface Factory {

		fun create(@Assisted("breed") breed: Breed): BreedDetailViewModelFactory
	}
}