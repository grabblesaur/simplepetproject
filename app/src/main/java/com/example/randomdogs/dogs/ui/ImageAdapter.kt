package com.example.randomdogs.dogs.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.randomdogs.databinding.ImageItemBinding
import com.example.randomdogs.dogs.data.Image

class ImageAdapter : RecyclerView.Adapter<ImageViewHolder>() {

	private var imageList = mutableListOf<Image>()

	fun setData(value: List<Image>) {
		imageList.clear()
		imageList.addAll(value)
		notifyItemRangeChanged(0, value.size)
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
		val binding = ImageItemBinding.inflate(
			LayoutInflater.from(parent.context),
			parent,
			false
		)

		return ImageViewHolder(binding)
	}

	override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
		holder.bind(imageList[position])
	}

	override fun getItemCount(): Int =
		imageList.size
}

class ImageViewHolder(
	private val binding: ImageItemBinding
) : RecyclerView.ViewHolder(binding.root) {

	fun bind(image: Image) {
		Glide.with(binding.root)
			.load(image.url)
			.centerCrop()
			.into(binding.image)
	}
}