package com.example.randomdogs.dogs.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.randomdogs.dogs.data.Breed
import com.example.randomdogs.dogs.data.Image
import com.example.randomdogs.dogs.domain.GetImageListUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BreedDetailViewModel(
	breed: Breed,
	private val getImageListUseCase: GetImageListUseCase,
) : ViewModel() {

	val breedLiveData: LiveData<Breed> = MutableLiveData(breed)

	private var _images = MutableLiveData<List<Image>>()
	val images: LiveData<List<Image>> = _images

	fun loadImages() {
		CoroutineScope(Dispatchers.IO).launch {
			val imageList = getImageListUseCase.get(breedLiveData.value!!.id)
			_images.postValue(imageList)
		}
	}
}