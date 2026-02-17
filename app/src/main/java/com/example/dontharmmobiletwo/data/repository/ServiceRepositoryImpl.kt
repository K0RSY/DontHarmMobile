package com.example.dontharmmobiletwo.data.repository

import com.example.dontharmmobiletwo.data.model.Service

class ServiceRepositoryImpl: ServiceRepository {
    override fun getService(): List<Service> {
        return listOf(
            Service("Тест 1", "Описание 1", "Категория 1", 120.2),
            Service("Тест 2", "Описание 2", "Категория 1", 220.83),
            Service("Тест 3", "Описание 3", "Категория 2", 410.1),
            Service("Тест 4", "Описание 4", "Категория 3", 12.1),
        )
    }
}