package kg.npml.photogrid.di

import kg.npml.feature.photogrid.di.PhotoGridModule
import org.koin.dsl.module
import org.koin.ksp.generated.module

val mainModule = module {
    includes(
        PhotoGridModule().module
    )
}