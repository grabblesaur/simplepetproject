package com.example.randomdogs.dogs.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randomdogs.dogs.data.Breed
import com.example.randomdogs.dogs.data.Image
import com.example.randomdogs.dogs.domain.GetImageListUseCase
import kotlinx.coroutines.launch

class BreedDetailViewModel(
	private val breed: Breed,
	private val getImageListUseCase: GetImageListUseCase,
) : ViewModel() {

	val breedLiveData: LiveData<Breed> = MutableLiveData(breed)

	private var _images = MutableLiveData<List<Image>>()
	val images: LiveData<List<Image>> = _images

	fun loadImages() {
		viewModelScope.launch {
			_images.value = getImageListUseCase(breed.id)
		}
	}
}