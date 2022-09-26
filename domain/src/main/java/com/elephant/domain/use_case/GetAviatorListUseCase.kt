package com.elephant.domain.use_case

import com.elephant.domain.models.InfoModel
import com.elephant.domain.repository.AviatorRepository

class GetAviatorListUseCase(private val aviatorRepository: AviatorRepository) {
    suspend fun execute(): List<InfoModel> {
        return aviatorRepository.getAviatorList()
    }
}