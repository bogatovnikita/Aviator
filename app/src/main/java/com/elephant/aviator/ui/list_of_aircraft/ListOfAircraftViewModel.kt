package com.elephant.aviator.ui.list_of_aircraft

import androidx.lifecycle.ViewModel
import com.elephant.domain.use_case.GetAviatorListUseCase

class ListOfAircraftViewModel(private val getAviatorListUseCase: GetAviatorListUseCase) :
    ViewModel() {
}