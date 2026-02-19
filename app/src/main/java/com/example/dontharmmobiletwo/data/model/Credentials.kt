package com.example.dontharmmobiletwo.data.model

import kotlinx.serialization.Serializable
import java.time.LocalDate
import java.time.Period

@Serializable
data class Credentials(
    val login: String = "",
    val password: String = ""
) {
    fun isNotEmpty(): Boolean {
        return login.isNotEmpty() && password.isNotEmpty()
    }
}
