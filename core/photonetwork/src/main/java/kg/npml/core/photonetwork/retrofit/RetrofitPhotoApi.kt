package kg.npml.core.photonetwork.retrofit

import retrofit2.http.GET

interface RetrofitPhotoApi {
    @GET()
    fun getKek()

}