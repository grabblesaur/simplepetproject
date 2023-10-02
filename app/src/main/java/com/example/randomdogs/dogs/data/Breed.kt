package com.example.randomdogs.dogs.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Breed(
	val id: String,
	val name: String,
	@SerializedName("bred_for")
	val bredFor: String,
	@SerializedName("breed_group")
	val breedGroup: String,
	@SerializedName("life_span")
	val lifeSpan: String,
	val temperament: String,
	val origin: String,
	@SerializedName("reference_image_id")
	val referenceImageId: String,
	val image: Image,
) : Parcelable
