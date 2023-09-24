package com.example.randomdogs.dogs.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.randomdogs.R
import com.example.randomdogs.dogs.data.Breed
import com.example.randomdogs.dogs.data.BreedRemoteDataSourceImpl
import com.example.randomdogs.dogs.data.BreedRepositoryImpl
import com.example.randomdogs.dogs.domain.GetBreedListUseCase
import com.example.randomdogs.dogs.presentation.BreedsViewModel
import com.example.randomdogs.dogs.presentation.BreedsViewModelFactory

class BreedsFragment : Fragment(R.layout.fragment_breeds) {

	lateinit var viewModel: BreedsViewModel

	companion object {

		fun newInstance(): Fragment =
			BreedsFragment()
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		setupViewModel()
		observeViewModel()
	}

	private fun setupViewModel() {
		val breedRemoteDataSource = BreedRemoteDataSourceImpl()
		val breedRepository = BreedRepositoryImpl(breedRemoteDataSource)
		val getBreedListUseCase = GetBreedListUseCase(breedRepository)
		val factory = BreedsViewModelFactory(getBreedListUseCase)

		viewModel = ViewModelProvider(
			owner = this,
			factory = factory
		)[BreedsViewModel::class.java]
	}

	private fun observeViewModel() {
		viewModel.breeds.observe(viewLifecycleOwner) { onBreedChanged(it) }
	}

	private fun onBreedChanged(breeds: List<Breed>) {

	}
}