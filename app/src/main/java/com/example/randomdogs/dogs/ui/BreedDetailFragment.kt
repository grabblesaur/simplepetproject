package com.example.randomdogs.dogs.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.randomdogs.R
import com.example.randomdogs.appComponent
import com.example.randomdogs.databinding.FragmentBreedDetailBinding
import com.example.randomdogs.dogs.data.Breed
import com.example.randomdogs.dogs.data.Image
import com.example.randomdogs.dogs.presentation.BreedDetailViewModel
import com.example.randomdogs.dogs.presentation.BreedDetailViewModelFactory
import com.example.randomdogs.parcelable
import javax.inject.Inject

class BreedDetailFragment : Fragment() {

	private var _binding: FragmentBreedDetailBinding? = null
	private val binding get() = _binding!!

	@Inject
	lateinit var factory: BreedDetailViewModelFactory.Factory

	private val breed: Breed by lazy { requireArguments().parcelable(BREED_KEY)!! }
	private val viewModel: BreedDetailViewModel by viewModels { factory.create(breed) }

	private val imageAdapter = ImageAdapter()

	companion object {
		private const val BREED_KEY = "BREED_KEY"
		private const val SPAN_COUNT = 3

		fun newInstance(breed: Breed): Fragment {
			val fragment = BreedDetailFragment()
			val bundle = Bundle().apply { putParcelable(BREED_KEY, breed) }
			fragment.arguments = bundle
			return fragment
		}
	}

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		requireContext().appComponent.inject(this)
		_binding = FragmentBreedDetailBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		setupRecyclerView()

		viewModel.breedLiveData.observe(viewLifecycleOwner) { showBreed(it) }
		viewModel.images.observe(viewLifecycleOwner) { showImages(it) }

		viewModel.loadImages()
	}

	private fun setupRecyclerView() {
		with(binding) {
			val itemOffset = resources.getDimensionPixelOffset(R.dimen.image_item_offset)
			val itemDecoration = GridItemDecoration(itemOffset)

			imagesRecycler.adapter = imageAdapter
			imagesRecycler.addItemDecoration(itemDecoration)
			imagesRecycler.layoutManager = object : GridLayoutManager(
				requireContext(),
				SPAN_COUNT,
			) {
				override fun canScrollVertically(): Boolean = false
			}
		}
	}

	private fun showBreed(breed: Breed) {
		with(binding) {
			name.text = breed.name

			Glide.with(requireContext())
				.load(breed.image.url)
				.circleCrop()
				.into(image)

			applyProperty(temperament, getString(R.string.temperament), breed.temperament)
			applyProperty(countryCode, getString(R.string.country_code), breed.countryCode)
			applyProperty(bredFor, getString(R.string.bred_for), breed.bredFor)
			applyProperty(breedGroup, getString(R.string.breed_group), breed.breedGroup)
			applyProperty(lifeSpan, getString(R.string.life_span), breed.lifeSpan)
		}
	}

	private fun applyProperty(textView: TextView, preText: String, text: String?) {
		if (!text.isNullOrEmpty()) {
			textView.text = getString(R.string.optional_text, preText, text)
			textView.isVisible = true
		}
	}

	private fun showImages(list: List<Image>) {
		imageAdapter.setData(list)
	}
}