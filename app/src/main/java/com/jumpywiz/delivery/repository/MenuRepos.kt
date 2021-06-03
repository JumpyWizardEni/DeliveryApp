package com.jumpywiz.delivery.repository

import com.jumpywiz.delivery.BuildConfig
import com.jumpywiz.delivery.helpers.TransactionHelper
import com.jumpywiz.delivery.db.MenuDAO
import com.jumpywiz.delivery.model.MenuItem
import com.jumpywiz.delivery.net.RetrofitService

class MenuRepos(private val menuDao: MenuDAO, private val retrofitService: RetrofitService) {
    private lateinit var result: List<MenuItem>

    suspend fun getNetData(foodType: String): List<MenuItem> {
        val requestAnswer =
            retrofitService.getPizzaData(foodType, BuildConfig.appId, BuildConfig.apiKey)
        result = TransactionHelper.toDBModel(requestAnswer, foodType)
        menuDao.deleteAll(foodType)
        menuDao.insertAll(result)
        return result
    }

    suspend fun loadData(foodType: String): List<MenuItem> {
        result = menuDao.getAll(foodType)
        if (result != emptyList<MenuItem>()) {
            return result
        }
        return getNetData(foodType)
    }

}