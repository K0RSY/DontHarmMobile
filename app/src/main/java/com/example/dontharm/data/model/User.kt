package com.example.dontharm.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(false)
    var login: String,

    @ColumnInfo(name="password")
    var password: String,

    @ColumnInfo(name="names")
    var names: String,

    @ColumnInfo(name="email")
    var email: String,

    @ColumnInfo(name="birthDate")
    var birthDate: String,

    @ColumnInfo(name="phone")
    var phone: String
)
