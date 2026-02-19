package com.example.dontharmmobiletwo.viewmodel

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.dontharmmobiletwo.data.model.User
import com.example.dontharmmobiletwo.data.repository.UserRepository

class ProfileViewModel(context: Context, login: String): ViewModel() {
    val repository = UserRepository(context)

    val user = repository.getUser(login)

    public var login by mutableStateOf(user.login)
    public var password by mutableStateOf(user.password)
    public var names by mutableStateOf(user.names)
    public var birthDate by mutableStateOf(user.birthDate)
    public var email by mutableStateOf(user.email)
    public var phone by mutableStateOf(user.phone)

    fun changePassword(value: String) {
        password = value
    }
    fun changeNames(value: String) {
        names = value
    }
    fun changeBirthDate(value: String) {
        birthDate = value
    }
    fun changeEmail(value: String) {
        email = value
    }
    fun changePhone(value: String) {
        phone = value
    }

    fun updateUser() {
        repository.setUser(
            User(login, password, names, birthDate, phone, email)
        )
    }
}