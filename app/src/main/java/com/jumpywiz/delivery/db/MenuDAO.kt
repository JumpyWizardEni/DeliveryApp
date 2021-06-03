package com.jumpywiz.delivery.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.jumpywiz.delivery.model.MenuItem

@Dao
interface MenuDAO {
    @Query("SELECT * FROM menuitem WHERE type = :type")
    suspend fun getAll(type: String): List<MenuItem>

    @Insert
    suspend fun insert(menuItem: MenuItem)

    @Insert
    suspend fun insertAll(menuItems: List<MenuItem>)

    @Query("DELETE FROM menuitem WHERE type = :type")
    suspend fun deleteAll(type: String)


}