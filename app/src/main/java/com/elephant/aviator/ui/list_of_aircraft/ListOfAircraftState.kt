package com.elephant.aviator.ui.list_of_aircraft

import com.elephant.domain.models.InfoModel


data class ListOfAircraftState(
    val listOfAircraft: List<InfoModel> = emptyList(),

    )