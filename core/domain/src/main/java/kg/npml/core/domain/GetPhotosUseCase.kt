package kg.npml.core.domain

import androidx.paging.PagingData
import kg.npml.core.common.model.Photo
import kg.npml.core.data.PhotoRepository
import kotlinx.coroutines.flow.Flow
import org.koin.core.annotation.Factory

/**
 * Юзкейс для получения фотографий
 */
@Factory
class GetPhotosUseCase(private val photoRepository: PhotoRepository) {
    operator fun invoke(category: String): Flow<PagingData<Photo>> = photoRepository.getPhotoByCategory(category)

}