package kg.npml.core.data.pagind

import androidx.paging.PagingSource
import androidx.paging.PagingState
import kg.npml.core.common.model.Photo
import kg.npml.core.data.mapper.toEntryPhoto
import kg.npml.core.photonetwork.model.PhotoResponseDto

/**
 * PagingSource из paging3 для фотографий
 */
class PhotoPagingSource(
    private val category: String,
    private val loader: suspend (String, Int) -> PhotoResponseDto
): PagingSource<Int, Photo>() {
    override fun getRefreshKey(state: PagingState<Int, Photo>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Photo> {
        return try {
            val page = params.key ?: 1
            val response = loader(category, page)
            val photos = response.photos.map { it.toEntryPhoto() }
            LoadResult.Page(
                data = photos,
                prevKey = if (page == 1) null else page.minus(1),
                nextKey = if (photos.isEmpty()) null else page.plus(1),
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}