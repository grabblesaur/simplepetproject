package com.example.randomdogs.dogs.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.randomdogs.databinding.BreedItemBinding
import com.example.randomdogs.dogs.data.Breed

class BreedPagingDataAdapter(
	diffCallback: DiffUtil.ItemCallback<Breed>
) : PagingDataAdapter<Breed, BreedViewHolder>(diffCallback) {

	private var listener: ((Breed) -> Unit)? = null

	fun setOnItemClickListener(listener: (Breed) -> Unit) {
		this.listener = listener
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreedViewHolder {
		val layoutInflater = LayoutInflater.from(parent.context)
		val binding = BreedItemBinding.inflate(layoutInflater, parent, false)

		return BreedViewHolder(binding, listener)
	}

	override fun onBindViewHolder(holder: BreedViewHolder, position: Int) {
		getItem(position)?.let {
			holder.bind(it)
		} ?: throw IllegalArgumentException("getItem at position $position is absent")
	}
}

object BreedComparator : DiffUtil.ItemCallback<Breed>() {

	override fun areItemsTheSame(oldItem: Breed, newItem: Breed): Boolean =
		oldItem.id == newItem.id

	override fun areContentsTheSame(oldItem: Breed, newItem: Breed): Boolean =
		oldItem == newItem
}