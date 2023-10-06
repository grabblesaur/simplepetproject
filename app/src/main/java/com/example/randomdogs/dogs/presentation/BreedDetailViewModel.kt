package com.example.randomdogs.dogs.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.randomdogs.dogs.data.Breed
import com.example.randomdogs.dogs.data.Image

class BreedDetailViewModel(breed: Breed) : ViewModel() {

	val breedLiveData: LiveData<Breed> = MutableLiveData(breed)

	private var _images = MutableLiveData<List<Image>>()
	val images: LiveData<List<Image>> = _images

	fun loadImages() {
		// TODO
	}
}