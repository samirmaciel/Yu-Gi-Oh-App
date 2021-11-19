package com.samirmaciel.yugiohapp

import android.app.Application
import com.samirmaciel.yugiohapp.shared.di.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(mainModule)
        }
    }
}