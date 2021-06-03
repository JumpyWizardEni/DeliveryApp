package com.jumpywiz.delivery.di

import com.jumpywiz.delivery.db.MenuDAO
import com.jumpywiz.delivery.net.RetrofitService
import com.jumpywiz.delivery.repository.MenuRepos
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
class ReposModule {

    @Provides
    @Singleton
    fun provideRepos(menuDao: MenuDAO, retrofitService: RetrofitService) = MenuRepos(menuDao, retrofitService)
}