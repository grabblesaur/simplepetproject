package com.example.randomdogs.dogs.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.randomdogs.databinding.BreedItemBinding
import com.example.randomdogs.dogs.data.Breed

class BreedAdapter : RecyclerView.Adapter<BreedViewHolder>() {

	private var breedList = mutableListOf<Breed>()

	fun addBreeds(breedList: List<Breed>) {
		this.breedList.addAll(breedList)
		notifyItemRangeInserted(breedList.size, breedList.size)
	}

	override fun onCreateViewHolder(
		parent: ViewGroup,
		viewType: Int
	): BreedViewHolder {
		val layoutInflater = LayoutInflater.from(parent.context)
		val binding = BreedItemBinding.inflate(layoutInflater, parent, false)

		return BreedViewHolder(binding)
	}

	override fun getItemCount(): Int =
		breedList.size

	override fun onBindViewHolder(holder: BreedViewHolder, position: Int) {
		holder.bind(breedList[position])
	}
}

class BreedViewHolder(
	private val binding: BreedItemBinding,
) : RecyclerView.ViewHolder(binding.root) {

	fun bind(breed: Breed) {
		binding.breedItemText.text = breed.name
	}
}