package com.elephant.data.repository

import com.elephant.data.storage.AviatorStorage
import com.elephant.domain.models.InfoModel
import com.elephant.domain.repository.AviatorRepository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class AviatorRepositoryImplementation(private val aviatorStorage: AviatorStorage) :
    AviatorRepository {
    override suspend fun getAviatorList(): List<InfoModel> {
        val jsonFileString = aviatorStorage.get("Aviator.json")
        val gson = Gson()
        val listPersonType = object : TypeToken<List<InfoModel>>() {}.type
        return gson.fromJson(jsonFileString, listPersonType)
    }
}