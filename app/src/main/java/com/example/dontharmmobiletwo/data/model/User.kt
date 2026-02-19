package com.example.dontharmmobiletwo.data.model

import kotlinx.serialization.Serializable
import java.time.LocalDate
import java.time.Period

@Serializable
data class User(
    val login: String,
    val password: String,
    val names: String,
    val birthDate: String,
    val phone: String,
    val email: String
) {
    fun getAge(): Int {
        val birth = LocalDate.parse(birthDate)
        val current = LocalDate.now()
        return Period.between(birth, current).years
    }
}
