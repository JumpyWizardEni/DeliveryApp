package com.jumpywiz.delivery.db

import android.content.Context

import androidx.room.*
import com.jumpywiz.delivery.model.MenuItem


@Database(entities = [MenuItem::class], version = 1)
abstract class MenuDatabase: RoomDatabase() {
    abstract fun menuDao(): MenuDAO
    companion object{
        private var instance: MenuDatabase? = null
        fun getInstance(context: Context): MenuDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(context.applicationContext,
                    MenuDatabase::class.java, "Menu").fallbackToDestructiveMigration().build()
            }
            return instance as MenuDatabase
        }
    }

}