package kg.npml.core.data

import kg.npml.core.photonetwork.PhotoDataSource
import org.koin.core.annotation.Single

@Single
class PexelsRepository(private val dataSource: PhotoDataSource): PhotoRepository{

}

