package com.jumpywiz.delivery.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MenuItem (
    var foodName: String?,
    var imageURL: String?,
    var type: String,
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

)