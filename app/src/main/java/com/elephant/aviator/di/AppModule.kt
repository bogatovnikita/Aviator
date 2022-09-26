package com.elephant.aviator.di

import com.elephant.aviator.ui.description_aircraft.DescriptionAircraftViewModel
import com.elephant.aviator.ui.list_of_aircraft.ListOfAircraftViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<ListOfAircraftViewModel> {
        ListOfAircraftViewModel(getAviatorListUseCase = get())
    }

    viewModel<DescriptionAircraftViewModel> {
        DescriptionAircraftViewModel()
    }
}