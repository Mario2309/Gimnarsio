package es.etg.dam.pmdm13.gym.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import es.etg.dam.pmdm13.gym.ui.state.CalendarioUIState

class CalendarioViewModel: ViewModel() {
    private val _estadoCalendario = MutableLiveData<CalendarioUIState>(CalendarioUIState.Loading)
    val estadoCalendario: LiveData<CalendarioUIState> get() = _estadoCalendario

}