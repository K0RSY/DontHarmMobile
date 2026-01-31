package com.example.dontharm.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class News(
    @PrimaryKey(true)
    var id: Long = 0L,

    @ColumnInfo(name="header")
    var header: String,

    @ColumnInfo(name="date")
    var date: String,

    @ColumnInfo(name="content")
    var content: String
)
