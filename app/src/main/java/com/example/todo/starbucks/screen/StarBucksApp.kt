package com.example.todo.starbucks.screen

import android.app.Application
import com.example.todo.starbucks.di.networkModule
import com.example.todo.starbucks.di.repositoryModule
import com.example.todo.starbucks.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class StarBucksApp: Application() {

    override fun onCreate() {
        super.onCreate()
        
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@StarBucksApp)
            modules(
                networkModule,
                repositoryModule,
                viewModelModule
            )
        }
    }

}