package com.example.randomdogs.dogs.data

interface BreedRemoteDataSource {

	fun get(): List<Breed>
}

class BreedRemoteDataSourceImpl : BreedRemoteDataSource {

	override fun get(): List<Breed> {
		val list = mutableListOf<Breed>()

		list.add(Breed(1, "first"))
		list.add(Breed(2, "second"))
		list.add(Breed(3, "third"))
		list.add(Breed(4, "fourth"))
		list.add(Breed(5, "fifth"))

		return list
	}
}