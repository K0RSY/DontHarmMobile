package com.example.dontharm.data.model

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class Service(
    @PrimaryKey(false)
    var code: Long = 0L,

    @ColumnInfo(name="name")
    var name: String,

    @ColumnInfo(name="price")
    var price: Double
)
