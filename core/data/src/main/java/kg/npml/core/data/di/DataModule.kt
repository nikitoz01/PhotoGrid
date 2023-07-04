package kg.npml.core.data.di

import kg.npml.core.photonetwork.di.PhotoNetworkModule
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module

@Module(includes = [PhotoNetworkModule::class])
@ComponentScan("kg.npml.core.data")
class DataModule