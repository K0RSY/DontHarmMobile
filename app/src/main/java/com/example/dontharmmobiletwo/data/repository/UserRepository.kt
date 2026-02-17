package com.example.dontharmmobiletwo.data.repository

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.example.dontharmmobiletwo.data.model.User
import android.content.SharedPreferences
import androidx.core.content.edit
import kotlinx.serialization.json.Json
import kotlin.math.log

class UserRepository(private val context: Context) {
    val sharedPreferences = context.getSharedPreferences("app_prefs", MODE_PRIVATE)

    suspend fun register(login: String, password: String) {
        val user = User(login, password, "", "", "", "", "", "")
        setUser(user)
        setAuthorized(login)
    }

    suspend fun authorize(login: String, password: String) {
        val user = getUser(login)

        if (user.password == password) {
            setAuthorized(login)
        }
    }

    suspend fun setUser(user: User) {
        val jsonUser = Json.encodeToString(user)
        sharedPreferences.edit { putString(user.login, jsonUser) }
    }

    suspend fun setAuthorized(login: String) {
        sharedPreferences.edit { putString("authorized", login) }
    }

    suspend fun getUser(login: String): User {
        val jsonUser: String = sharedPreferences.getString(login, "").toString()

        if (jsonUser != "") {
            val user = Json.decodeFromString<User>(jsonUser)
            return user
        }

        return User("", "", "", "", "", "", "", "")
    }
}