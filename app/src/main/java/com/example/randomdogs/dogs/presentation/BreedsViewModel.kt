package com.example.randomdogs.dogs.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randomdogs.dogs.data.Breed
import com.example.randomdogs.dogs.domain.GetBreedListUseCase
import kotlinx.coroutines.launch

class BreedsViewModel(
	private val getBreedListUseCase: GetBreedListUseCase,
) : ViewModel() {

	private var _breeds = MutableLiveData<List<Breed>>()
	val breeds: LiveData<List<Breed>> = _breeds

	fun loadDogs() {
		viewModelScope.launch {
			_breeds.value = getBreedListUseCase()
		}
	}
}