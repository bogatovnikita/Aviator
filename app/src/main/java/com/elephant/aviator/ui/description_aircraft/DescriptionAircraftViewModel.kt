package com.elephant.aviator.ui.description_aircraft

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.elephant.domain.models.InfoModel

class DescriptionAircraftViewModel() : ViewModel() {

    private val _state = MutableLiveData(DescriptionAircraftState())
    val state: LiveData<DescriptionAircraftState> = _state

    private val currentState: DescriptionAircraftState
        get() = state.value!!

    fun initState(infoModel: InfoModel) {
        _state.value = currentState.copy(
            textList = infoModel.texts,
            listPictures = infoModel.images
        )
    }

}