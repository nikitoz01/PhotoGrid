package kg.npml.feature.photogrid.di

import kg.npml.core.domain.di.DomainModule
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module

@Module(includes = [DomainModule::class])
@ComponentScan("kg.npml.feature.photogrid")
class PhotoGridModule