package kg.npml.core.photonetwork.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kg.npml.core.photonetwork.BuildConfig
import kg.npml.core.photonetwork.retrofit.RetrofitPhotoApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import retrofit2.Retrofit

//val photoNetworkModule = module {
//    singleOf()
//}

@Module
@ComponentScan("kg.npml.core.photonetwork")
class PhotoNetworkModule{
    @Single
    fun retrofitPhotoApi() = Retrofit
        .Builder()
        .client(
            OkHttpClient
                .Builder()
                .addInterceptor { chain ->
                    val request = chain
                        .request()
                        .newBuilder()
                        .addHeader("Authorization", BuildConfig.API_KEY)
                        .build()
                    chain.proceed(request)
                }

                .build()
        )
        .addConverterFactory(
            Json{ignoreUnknownKeys = true}
                .asConverterFactory(MediaType.get("application/json"))
        )
        .baseUrl("https://api.pexels.com/v1/")
        .build()
        .create(RetrofitPhotoApi::class.java)

}