package com.example.randomdogs.dogs.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.randomdogs.dogs.data.Breed

@Suppress("UNCHECKED_CAST")
class BreedDetailViewModelFactory(private val breed: Breed) : ViewModelProvider.Factory {

	override fun <T : ViewModel> create(modelClass: Class<T>): T =
		BreedDetailViewModel(breed) as T
}