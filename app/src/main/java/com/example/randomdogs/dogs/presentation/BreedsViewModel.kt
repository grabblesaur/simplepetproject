package com.example.randomdogs.dogs.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.randomdogs.dogs.data.Breed
import com.example.randomdogs.dogs.data.BreedPagingSource
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class BreedsViewModel(
	private val breedPagingSource: BreedPagingSource,
) : ViewModel() {

	var breeds: StateFlow<PagingData<Breed>> =
		Pager(config = PagingConfig(pageSize = 10)) { breedPagingSource }
			.flow
			.stateIn(viewModelScope, SharingStarted.Lazily, PagingData.empty())
}