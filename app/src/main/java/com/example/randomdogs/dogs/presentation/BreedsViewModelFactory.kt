package com.example.randomdogs.dogs.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.randomdogs.dogs.domain.GetBreedListUseCase

@Suppress("UNCHECKED_CAST")
class BreedsViewModelFactory(
	private val getBreedListUseCase: GetBreedListUseCase
) : ViewModelProvider.Factory {

	override fun <T : ViewModel> create(modelClass: Class<T>): T {
		return BreedsViewModel(getBreedListUseCase) as T
	}
}