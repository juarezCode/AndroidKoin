package com.juarez.koin

import android.app.Application
import com.juarez.koin.di.appModule
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(appModule)
        }
    }
}