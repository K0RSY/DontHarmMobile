package com.example.dontharmmobiletwo.data.repository

import android.content.Context
import com.example.dontharmmobiletwo.data.model.News

interface NewsRepository {
    fun getNews(context: Context): List<News>
}