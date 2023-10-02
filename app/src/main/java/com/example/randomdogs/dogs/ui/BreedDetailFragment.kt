package com.example.randomdogs.dogs.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.randomdogs.databinding.FragmentBreedDetailBinding
import com.example.randomdogs.dogs.data.Breed
import com.example.randomdogs.parcelable

class BreedDetailFragment : Fragment() {

	private var _binding: FragmentBreedDetailBinding? = null
	private val binding get() = _binding!!

	companion object {
		private const val BREED_KEY = "BREED_KEY"

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
		_binding = FragmentBreedDetailBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		val breed = requireArguments().parcelable<Breed>(BREED_KEY)!!
		binding.name.text = breed.name
	}
}