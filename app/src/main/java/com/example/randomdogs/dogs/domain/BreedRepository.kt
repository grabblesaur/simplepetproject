package com.example.randomdogs.dogs.domain

import com.example.randomdogs.dogs.data.Breed

interface BreedRepository {

	fun get(): List<Breed>
}