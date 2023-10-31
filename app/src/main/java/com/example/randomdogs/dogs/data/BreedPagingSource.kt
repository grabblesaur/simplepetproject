package com.example.randomdogs.dogs.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.randomdogs.dogs.api.BreedApi
import retrofit2.HttpException
import javax.inject.Inject

class BreedPagingSource @Inject constructor(
	val api: BreedApi
) : PagingSource<Int, Breed>() {

	override fun getRefreshKey(state: PagingState<Int, Breed>): Int? {
		val anchorPosition = state.anchorPosition ?: return null
		val anchorPage = state.closestPageToPosition(anchorPosition) ?: return null

		return anchorPage.prevKey?.plus(1) ?: anchorPage.nextKey?.minus(1)
	}

	override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Breed> {
		return try {
			val pageNumber = params.key ?: 1
			val breeds = api.get(pageNumber)
			val nextPageNumber = if (breeds.isEmpty()) null else pageNumber + 1
			val prevPageNumber = if (pageNumber > 1) pageNumber - 1 else null

			LoadResult.Page(breeds, prevPageNumber, nextPageNumber)
		} catch (e: HttpException) {
			LoadResult.Error(e)
		} catch (e: Exception) {
			LoadResult.Error(e)
		}
	}
}