package kg.npml.core.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import kg.npml.core.data.pagind.PhotoPagingSource
import kg.npml.core.photonetwork.PhotoDataSource
import org.koin.core.annotation.Single

@Single
class PexelsRepository(private val photoDataSource: PhotoDataSource) : PhotoRepository {
    override fun getPhotoByCategory(category: String) =
        Pager(
            config = PagingConfig(
                pageSize = 20,
            ),
            pagingSourceFactory = {
                PhotoPagingSource(category) { category, page ->
                    photoDataSource.getPhotoByCategory(category, page)
                }
            }
        ).flow
}

