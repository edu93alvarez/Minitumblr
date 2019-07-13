package pe.demo.minitumblr

import android.app.Application
import org.koin.core.context.startKoin
import pe.demo.minitumblr.di.postModule
import pe.demo.minitumblr.di.postRepositoryModule
import pe.demo.minitumblr.remote.di.networkModule

class MTApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(postModule, networkModule, postRepositoryModule)
        }
    }
}