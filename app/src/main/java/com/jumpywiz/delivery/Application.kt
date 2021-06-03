package com.jumpywiz.delivery

import android.app.Application
import com.jumpywiz.delivery.di.*

class Application : Application() {
    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    fun initDagger() {
        appComponent =
            DaggerAppComponent.builder().appModule(AppModule(context = this.applicationContext))
                .databaseModule(
                    DatabaseModule()
                ).remoteModule(RemoteModule()).reposModule(ReposModule())
                .build()
    }
}