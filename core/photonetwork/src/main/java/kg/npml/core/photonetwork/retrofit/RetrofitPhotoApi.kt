package kg.npml.core.photonetwork.retrofit

import kg.npml.core.photonetwork.model.PhotoResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Сетевой слой
 */
interface RetrofitPhotoApi {
    @GET("search/")
    suspend fun getPhotoByCategory(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int = 20
    ): PhotoResponseDto

}