package kg.npml.core.photonetwork

import kg.npml.core.photonetwork.retrofit.RetrofitPhotoApi
import org.koin.core.annotation.Single

@Single
class PhotoDataSource(private val retrofitPhotoApi: RetrofitPhotoApi) {

}