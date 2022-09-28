package com.elephant.aviator.ui.description_aircraft

import com.elephant.domain.models.TextModel

data class DescriptionAircraftState(
    val textList: List<TextModel> = emptyList(),
    val listPictures: Set<String>? = emptySet()
)