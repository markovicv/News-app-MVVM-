package com.example.news.app

import android.app.Application
import com.example.news.moduls.coreModule
import com.example.news.moduls.newsModul
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.fragment.koin.fragmentFactory
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class ApplicationProject :Application(){

    override fun onCreate() {
        super.onCreate()
        initTimber()
        initKoin()

    }
    private fun initTimber(){
        Timber.plant(Timber.DebugTree())
    }

    private fun initKoin(){
        val modules = listOf(
            coreModule,
            newsModul
        )
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@ApplicationProject)
            androidFileProperties()
            fragmentFactory()
            modules(modules)
        }
    }

}