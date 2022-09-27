package com.elephant.aviator.ui.list_of_aircraft

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elephant.domain.use_case.GetAviatorListUseCase
import kotlinx.coroutines.launch

class ListOfAircraftViewModel(private val getAviatorListUseCase: GetAviatorListUseCase) :
    ViewModel() {

    private val _state = MutableLiveData(ListOfAircraftState())
    val state: LiveData<ListOfAircraftState> = _state

    private val currentState: ListOfAircraftState
        get() = state.value!!

    init {
        getListOfAircraft()
    }

    private fun getListOfAircraft() {
        viewModelScope.launch {
            _state.value = currentState.copy(
                listOfAircraft = getAviatorListUseCase.execute()
            )
        }
    }
}