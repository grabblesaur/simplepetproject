package com.example.randomdogs.dogs.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.randomdogs.R
import com.example.randomdogs.RetrofitManager
import com.example.randomdogs.databinding.FragmentBreedsBinding
import com.example.randomdogs.dogs.api.BreedApi
import com.example.randomdogs.dogs.data.Breed
import com.example.randomdogs.dogs.data.BreedRemoteDataSourceImpl
import com.example.randomdogs.dogs.data.BreedRepositoryImpl
import com.example.randomdogs.dogs.domain.GetBreedListUseCase
import com.example.randomdogs.dogs.presentation.BreedsViewModel
import com.example.randomdogs.dogs.presentation.BreedsViewModelFactory
import kotlinx.coroutines.Dispatchers

class BreedsFragment : Fragment() {

	private lateinit var viewModel: BreedsViewModel

	private var _binding: FragmentBreedsBinding? = null
	private val binding get() = _binding!!

	private val breedAdapter = BreedAdapter()

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

		setupViews()

		viewModel.loadDogs()
	}

	private fun setupViewModel() {
		val api = RetrofitManager.instance.create(BreedApi::class.java)
		val breedRemoteDataSource = BreedRemoteDataSourceImpl(api)
		val breedRepository = BreedRepositoryImpl(breedRemoteDataSource, Dispatchers.IO)
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

	private fun setupViews() {
		with(binding) {
			breedListRecycler.layoutManager = LinearLayoutManager(requireContext())
			breedListRecycler.adapter = breedAdapter
			breedAdapter.setOnItemClickListener(::openDetailScreen)
		}
	}

	private fun openDetailScreen(breed: Breed) {
		parentFragmentManager.beginTransaction()
			.add(R.id.fragment_container, BreedDetailFragment.newInstance(breed))
			.addToBackStack(null)
			.commit()
	}

	private fun onBreedChanged(breeds: List<Breed>) {
		breedAdapter.setBreeds(breeds)
	}

	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}
}