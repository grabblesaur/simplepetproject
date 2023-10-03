package com.example.randomdogs.dogs.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.randomdogs.dogs.data.Breed

class BreedDetailViewModel(breed: Breed) : ViewModel() {

	val breedLiveData: LiveData<Breed> = MutableLiveData(breed)
}