package com.example.dontharmmobiletwo.data.repository

import android.content.Context
import com.example.dontharmmobiletwo.data.model.News
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.IOException

class NewsRepositoryImpl: NewsRepository {
    override fun getNews(context: Context): List<News> {
        val jsonString = getJsonFromAssets(context, "news.json")

        return Json.decodeFromString<List<News>>(jsonString!!)
    }

    fun getJsonFromAssets(context: Context, fileName: String): String? {
        return try {
            context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }
}