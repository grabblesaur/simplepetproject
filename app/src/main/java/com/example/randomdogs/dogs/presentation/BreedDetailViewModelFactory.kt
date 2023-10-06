package com.example.randomdogs.dogs.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.randomdogs.dogs.data.Breed
import com.example.randomdogs.dogs.domain.GetImageListUseCase

@Suppress("UNCHECKED_CAST")
class BreedDetailViewModelFactory(
	private val breed: Breed,
	private val getImageListUseCase: GetImageListUseCase,
) : ViewModelProvider.Factory {

	override fun <T : ViewModel> create(modelClass: Class<T>): T =
		BreedDetailViewModel(breed, getImageListUseCase) as T
}