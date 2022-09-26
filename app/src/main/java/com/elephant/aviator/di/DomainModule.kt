package com.elephant.aviator.di

import com.elephant.domain.use_case.GetAviatorListUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<GetAviatorListUseCase> {
        GetAviatorListUseCase(aviatorRepository = get())
    }
}