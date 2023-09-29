package com.example.randomdogs.dogs.domain

import com.example.randomdogs.dogs.data.Breed

interface BreedRepository {

	suspend fun get(): List<Breed>
}