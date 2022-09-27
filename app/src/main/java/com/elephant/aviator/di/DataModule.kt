package com.elephant.aviator.di

import com.elephant.data.repository.AviatorRepositoryImplementation
import com.elephant.data.storage.AviatorStorage
import com.elephant.data.storage.AviatorStorageImplementation
import com.elephant.domain.repository.AviatorRepository
import org.koin.dsl.module

val dataModule = module {
    single<AviatorStorage> {
        AviatorStorageImplementation(context = get())
    }

    single<AviatorRepository> {
        AviatorRepositoryImplementation(aviatorStorage = get())
    }
}