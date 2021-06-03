package com.jumpywiz.delivery.net

import androidx.lifecycle.LiveData
import com.jumpywiz.delivery.model.RequestAnswer
import retrofit2.http.GET
import retrofit2.http.Query
import java.security.Key


interface RetrofitService {

    @GET("parser?category=generic-foods")
    suspend fun getPizzaData(
        @Query("ingr") foodType: String, @Query("app_id") appId: String,
    @Query("app_key") appKey: String): RequestAnswer
}