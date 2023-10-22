package com.example.randomdogs

import android.content.Context
import android.content.Intent
import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import android.os.Parcelable
import com.example.randomdogs.di.AppComponent
import com.example.randomdogs.di.MyApplication

inline fun <reified T : Parcelable> Intent.parcelable(key: String): T? = when {
	SDK_INT >= 33 -> getParcelableExtra(key, T::class.java)
	else -> @Suppress("DEPRECATION") getParcelableExtra(key) as? T
}

inline fun <reified T : Parcelable> Bundle.parcelable(key: String): T? = when {
	SDK_INT >= 33 -> getParcelable(key, T::class.java)
	else -> @Suppress("DEPRECATION") getParcelable(key) as? T
}

val Context.appComponent: AppComponent
	get() = when (this) {
		is MyApplication -> appComponent
		else -> this.applicationContext.appComponent
	}