package com.example.randomdogs.dogs.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.randomdogs.dogs.domain.GetBreedListUseCase
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class BreedsViewModelFactory @Inject constructor(
	private val getBreedListUseCase: GetBreedListUseCase
) : ViewModelProvider.Factory {

	override fun <T : ViewModel> create(modelClass: Class<T>): T {
		require(modelClass == BreedsViewModel::class.java)
		return BreedsViewModel(getBreedListUseCase) as T
	}
}