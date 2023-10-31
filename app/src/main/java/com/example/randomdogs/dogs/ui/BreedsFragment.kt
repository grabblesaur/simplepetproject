package com.example.randomdogs.dogs.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.randomdogs.R
import com.example.randomdogs.appComponent
import com.example.randomdogs.databinding.FragmentBreedsBinding
import com.example.randomdogs.dogs.data.Breed
import com.example.randomdogs.dogs.presentation.BreedsViewModel
import com.example.randomdogs.dogs.presentation.BreedsViewModelFactory
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class BreedsFragment : Fragment() {

	@Inject
	lateinit var factory: BreedsViewModelFactory
	private val viewModel: BreedsViewModel by viewModels { factory }

	private var _binding: FragmentBreedsBinding? = null
	private val binding get() = _binding!!

	private val breedAdapter = BreedPagingDataAdapter(BreedComparator)

	companion object {

		fun newInstance(): Fragment =
			BreedsFragment()
	}

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		requireContext().appComponent.inject(this)
		_binding = FragmentBreedsBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		observeViewModel()

		setupViews()
	}

	private fun observeViewModel() {
		viewLifecycleOwner.lifecycleScope.launch {
			viewModel.breeds.collectLatest(breedAdapter::submitData)
		}
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

	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}
}