package com.example.randomdogs.di

import android.app.Application

class MyApplication : Application() {

	lateinit var appComponent: AppComponent

	override fun onCreate() {
		super.onCreate()

		appComponent = DaggerAppComponent.create()
	}
}