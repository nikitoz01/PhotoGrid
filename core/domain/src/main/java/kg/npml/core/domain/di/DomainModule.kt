package kg.npml.core.domain.di

import kg.npml.core.data.di.DataModule
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module

@Module(includes = [DataModule::class])
@ComponentScan("kg.npml.core.domain")
class DomainModule