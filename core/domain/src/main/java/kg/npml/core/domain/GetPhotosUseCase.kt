package kg.npml.core.domain

import kg.npml.core.data.PhotoRepository
import org.koin.core.annotation.Factory

@Factory
class GetPhotosUseCase(private val photoRepository: PhotoRepository) {
    operator fun invoke(){

    }
}