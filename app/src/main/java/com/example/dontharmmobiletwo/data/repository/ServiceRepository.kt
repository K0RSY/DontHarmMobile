package com.example.dontharmmobiletwo.data.repository

import com.example.dontharmmobiletwo.data.model.Service

interface ServiceRepository {
    fun getService(): List<Service>
}