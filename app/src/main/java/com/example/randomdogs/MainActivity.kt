package com.example.randomdogs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.randomdogs.dogs.ui.BreedsFragment

class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		supportFragmentManager.beginTransaction()
			.replace(R.id.fragment_container, BreedsFragment.newInstance())
			.commit()
	}
}

/***
 * TODO List:
 * мини апп для отображения информации из апи
 * https://dog.ceo/dog-api/
 *
 * Первоначальные действия:
 * - подключить view model вручную
 * - подключить use case, repository, datasource для получения списка собак вручную
 * - отобразить в виде списка
 *
 * Бонусные хотелки:
 * - использовать DI-фреймворк (Dagger2, Koin etc)
 * - посмотреть как разделить app-модуль на саб-модули
 * - подумать над использованием боттомшита
 * - попробовать написать собственную навигацию
 * - написать собственную мини-дизайн систему (?)
 */