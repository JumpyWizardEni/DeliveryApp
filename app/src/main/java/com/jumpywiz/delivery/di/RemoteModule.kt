package com.jumpywiz.delivery.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jumpywiz.delivery.net.RetrofitService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RemoteModule {
    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson) = Retrofit.Builder()
        .baseUrl("https://api.edamam.com/api/food-database/v2/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
    @Provides
    fun provideRetrofitService(retrofit:Retrofit) = retrofit.create(RetrofitService::class.java)
    @Provides
    fun provideGsonFactory() = GsonBuilder().setLenient().create()

}