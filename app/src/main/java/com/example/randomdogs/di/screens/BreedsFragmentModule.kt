package com.example.randomdogs.di.screens

import com.example.randomdogs.di.modules.NetworkModule
import dagger.Module

@Module(includes = [NetworkModule::class])
interface BreedsFragmentModule