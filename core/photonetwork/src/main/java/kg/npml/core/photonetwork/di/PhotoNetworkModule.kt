package kg.npml.core.photonetwork.di

import kg.npml.core.photonetwork.retrofit.RetrofitPhotoApi
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
        .baseUrl("https://api.pexels.com/v1/")
        .build()
        .create(RetrofitPhotoApi::class.java)

}