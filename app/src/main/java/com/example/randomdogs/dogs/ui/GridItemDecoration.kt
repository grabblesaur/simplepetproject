package com.example.randomdogs.dogs.ui

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration

class GridItemDecoration(private val itemOffset: Int) : ItemDecoration() {

	override fun getItemOffsets(
		outRect: Rect,
		view: View,
		parent: RecyclerView,
		state: RecyclerView.State
	) {
		super.getItemOffsets(outRect, view, parent, state)

		outRect.top = itemOffset
		outRect.left = itemOffset
		outRect.right = itemOffset
		outRect.bottom = itemOffset
	}
}
