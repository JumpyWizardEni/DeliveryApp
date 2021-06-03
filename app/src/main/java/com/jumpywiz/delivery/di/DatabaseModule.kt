package com.jumpywiz.delivery.di

import android.content.Context
import com.jumpywiz.delivery.db.MenuDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDB(context: Context) = MenuDatabase.getInstance(context)

    @Provides
    fun provideDAO(db: MenuDatabase) = db.menuDao()
}