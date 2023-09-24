package com.example.randomdogs.dogs.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.randomdogs.dogs.data.Breed
import com.example.randomdogs.dogs.domain.GetBreedListUseCase

class BreedsViewModel(
	private val getBreedListUseCase: GetBreedListUseCase,
) : ViewModel() {

	private var _breeds = MutableLiveData<List<Breed>>()
	val breeds: LiveData<List<Breed>> = _breeds

	fun loadDogs() {
		_breeds.value = getBreedListUseCase.get()
	}
}