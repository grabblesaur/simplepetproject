package com.example.randomdogs.dogs.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.randomdogs.dogs.data.Breed
import com.example.randomdogs.dogs.domain.GetBreedListUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class BreedsViewModel(
	private val getBreedListUseCase: GetBreedListUseCase,
) : ViewModel() {

	private var _breeds = MutableLiveData<List<Breed>>()
	val breeds: LiveData<List<Breed>> = _breeds

	fun loadDogs() {
		CoroutineScope(Dispatchers.IO).launch {
			val list = mutableListOf<Breed>()
			list.add(Breed("1", "qw"))
			list.add(Breed("2", "as"))
			list.add(Breed("3", "fa"))
			list.add(Breed("4", "asdzxc"))
			delay(1000)

			_breeds.postValue(list)

//			_breeds.postValue(getBreedListUseCase.get())
		}
	}
}