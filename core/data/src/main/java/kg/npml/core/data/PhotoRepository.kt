package kg.npml.core.data

import androidx.paging.PagingData
import kg.npml.core.common.model.Photo
import kotlinx.coroutines.flow.Flow


interface PhotoRepository{
    fun getPhotoByCategory(category: String): Flow<PagingData<Photo>>
}
