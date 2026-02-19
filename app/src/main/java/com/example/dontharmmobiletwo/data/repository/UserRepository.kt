package com.example.dontharmmobiletwo.data.repository

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.example.dontharmmobiletwo.data.model.User
import android.content.SharedPreferences
import androidx.core.content.edit
import kotlinx.serialization.json.Json
import kotlin.math.log

open class UserRepository(private val context: Context) {
    val sharedPreferences = context.getSharedPreferences("app_prefs", MODE_PRIVATE)

    fun register(login: String, password: String): Boolean {
        val user = User(login, password, "", "", "", "")
        setUser(user)
        setAuthorized(login)
        return true
    }

    fun authorize(login: String, password: String): Boolean {
        val user = getUser(login)

        if (user.password == password && password != "") {
            setAuthorized(login)

            return true
        }

        return false
    }

    fun setUser(user: User) {
        val jsonUser = Json.encodeToString(user)
        sharedPreferences.edit { putString(user.login, jsonUser) }
    }

    fun setAuthorized(login: String) {
        sharedPreferences.edit { putString("authorized", login) }
    }

    fun loadStartUsers() {
//        if (sharedPreferences.getBoolean("loaded", false)) {
            setUser(User("chacking0", "4tzqHdkqzo4", "Clareta Hacking", "2/10/2020", "8 800 555 35 35", "chacking0@mail.ru"))
            setUser(User("nmably1", "ukM0e6", "Northrop Mably", "6/20/2020", "8 800 555 35 35", "nmably1@mail.ru"))
            setUser(User("ivan", "123", "Ivan", "6/20/2020", "8 800 555 35 35", "ivan@mail.ru"))
//        }

        sharedPreferences.edit { putBoolean("loaded", true) }
    }

    fun getUser(login: String): User {
        val jsonUser: String = sharedPreferences.getString(login, "").toString()

        if (jsonUser != "") {
            val user = Json.decodeFromString<User>(jsonUser)
            return user
        }

        return User("", "", "", "", "", "")
    }
}