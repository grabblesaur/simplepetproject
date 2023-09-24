package com.example.randomdogs.dogs.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.randomdogs.databinding.FragmentBreedsBinding
import com.example.randomdogs.dogs.data.Breed
import com.example.randomdogs.dogs.data.BreedRemoteDataSourceImpl
import com.example.randomdogs.dogs.data.BreedRepositoryImpl
import com.example.randomdogs.dogs.domain.GetBreedListUseCase
import com.example.randomdogs.dogs.presentation.BreedsViewModel
import com.example.randomdogs.dogs.presentation.BreedsViewModelFactory

class BreedsFragment : Fragment() {

	private lateinit var viewModel: BreedsViewModel

	private var _binding: FragmentBreedsBinding? = null
	private val binding get() = _binding!!

	companion object {

		fun newInstance(): Fragment =
			BreedsFragment()
	}

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		_binding = FragmentBreedsBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		setupViewModel()
		observeViewModel()

		viewModel.loadDogs()
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
		binding.firstBreed.text = breeds.first().name
		binding.secondBreed.text = breeds[1].name
	}

	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}
}