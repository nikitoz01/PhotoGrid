package kg.npml.core.photonetwork

import kg.npml.core.photonetwork.model.PhotoResponseDto
import kg.npml.core.photonetwork.retrofit.RetrofitPhotoApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.annotation.Single

@Single
class PhotoDataSource(private val retrofitPhotoApi: RetrofitPhotoApi) {
    suspend fun getPhotoByCategory(category: String, page: Int): PhotoResponseDto  = withContext(Dispatchers.IO) {
             retrofitPhotoApi.getPhotoByCategory(category, page)
    }
}