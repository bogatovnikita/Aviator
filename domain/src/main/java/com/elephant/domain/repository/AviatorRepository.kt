package com.elephant.domain.repository

import com.elephant.domain.models.InfoModel

interface AviatorRepository {
    suspend fun getAviatorList(): List<InfoModel>
}