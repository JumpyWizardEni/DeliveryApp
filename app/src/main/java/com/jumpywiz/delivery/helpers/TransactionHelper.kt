package com.jumpywiz.delivery.helpers

import com.jumpywiz.delivery.model.MenuItem
import com.jumpywiz.delivery.model.RequestAnswer
import javax.inject.Singleton

@Singleton
class TransactionHelper {
    companion object {
        fun toDBModel(request: RequestAnswer, foodType: String): List<MenuItem> {
            var currId = 0
            val result = mutableListOf<MenuItem>()
            request.hints.forEach {
                result.add(MenuItem(it.food.label, it.food.image, foodType))
                currId++
            }
            return result
        }
    }
}