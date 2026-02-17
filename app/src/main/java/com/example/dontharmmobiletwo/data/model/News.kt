package com.example.dontharmmobiletwo.data.model

import kotlinx.serialization.Serializable

@Serializable
data class News(
    val title: String,
    val content: String,
    val date: String
)
