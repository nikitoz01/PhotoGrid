package kg.npml.photogrid

import android.app.Application
import kg.npml.photogrid.di.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class PhotoGridApp: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@PhotoGridApp)
            modules(mainModule)
        }

    }
}
