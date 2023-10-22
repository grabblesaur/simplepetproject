package com.example.randomdogs.di

import com.example.randomdogs.di.screens.BreedsFragmentModule
import com.example.randomdogs.dogs.ui.BreedsFragment
import dagger.Component

@Component(modules = [BreedsFragmentModule::class])
interface AppComponent {

	fun inject(fragment: BreedsFragment)
}