package com.example.dontharmmobiletwo.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.dontharmmobiletwo.data.repository.NewsRepository
import com.example.dontharmmobiletwo.data.repository.NewsRepositoryImpl
import com.example.dontharmmobiletwo.data.repository.ServiceRepository
import com.example.dontharmmobiletwo.data.repository.ServiceRepositoryImpl

class ServiceViewModel(): ViewModel() {
    private val serviceRepository: ServiceRepository = ServiceRepositoryImpl()

    fun getService() = serviceRepository.getService()
}