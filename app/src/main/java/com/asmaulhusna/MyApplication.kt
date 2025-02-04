package com.asmaulhusna

import android.app.Application
import com.asmaulhusna.core.di.databaseModule
import com.asmaulhusna.core.di.networkModule
import com.asmaulhusna.core.di.repositoryModel
import com.asmaulhusna.di.useCaseModule
import com.asmaulhusna.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModel,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}