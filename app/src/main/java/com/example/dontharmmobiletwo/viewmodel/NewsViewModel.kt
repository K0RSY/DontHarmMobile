package com.example.dontharmmobiletwo.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.dontharmmobiletwo.data.repository.NewsRepository
import com.example.dontharmmobiletwo.data.repository.NewsRepositoryImpl

class NewsViewModel(): ViewModel() {
    private val newsRepository: NewsRepository = NewsRepositoryImpl()

    fun getNews(context: Context) = newsRepository.getNews(context)
}