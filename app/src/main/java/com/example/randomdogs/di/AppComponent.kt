package com.example.randomdogs.di

import com.example.randomdogs.di.screens.BreedDetailFragmentModule
import com.example.randomdogs.di.screens.BreedsFragmentModule
import com.example.randomdogs.dogs.ui.BreedDetailFragment
import com.example.randomdogs.dogs.ui.BreedsFragment
import dagger.Component

@Component(modules = [BreedsFragmentModule::class, BreedDetailFragmentModule::class])
interface AppComponent {

	fun inject(fragment: BreedsFragment)

	fun inject(fragment: BreedDetailFragment)
}