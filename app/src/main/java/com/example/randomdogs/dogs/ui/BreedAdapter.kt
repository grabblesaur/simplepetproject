package com.example.randomdogs.dogs.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.randomdogs.databinding.BreedItemBinding
import com.example.randomdogs.dogs.data.Breed

class BreedAdapter : RecyclerView.Adapter<BreedViewHolder>() {

	private var breedList = mutableListOf<Breed>()
	private var listener: ((Breed) -> Unit)? = null

	fun setBreeds(breedList: List<Breed>) {
		this.breedList.clear()
		this.breedList.addAll(breedList)

		notifyItemRangeChanged(0, breedList.size)
	}

	fun setOnItemClickListener(listener: (Breed) -> Unit) {
		this.listener = listener
	}

	override fun onCreateViewHolder(
		parent: ViewGroup,
		viewType: Int
	): BreedViewHolder {
		val layoutInflater = LayoutInflater.from(parent.context)
		val binding = BreedItemBinding.inflate(layoutInflater, parent, false)

		return BreedViewHolder(binding, listener)
	}

	override fun getItemCount(): Int =
		breedList.size

	override fun onBindViewHolder(holder: BreedViewHolder, position: Int) {
		holder.bind(breedList[position])
	}
}

class BreedViewHolder(
	private val binding: BreedItemBinding,
	private val onClick: ((Breed) -> Unit)?,
) : RecyclerView.ViewHolder(binding.root) {

	fun bind(breed: Breed) {
		with(binding) {
			root.setOnClickListener { onClick?.invoke(breed) }

			Glide.with(root)
				.load(breed.image.url)
				.circleCrop()
				.into(image)

			name.text = breed.name
			temperament.text = breed.temperament
		}
	}
}