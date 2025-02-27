package es.etg.dam.pmdm13.gym.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import es.etg.dam.pmdm13.gym.ui.state.TornoUIState

class TornoViewModel : ViewModel() {

    private val _estadoTorno = MutableLiveData<TornoUIState>(TornoUIState.MostrarCalendario)
    val estadoTorno: LiveData<TornoUIState> get() = _estadoTorno

    fun abrirTorno() {
        _estadoTorno.value = TornoUIState.MostrarQR
    }

    fun cerrarTorno() {
        _estadoTorno.value = TornoUIState.MostrarCalendario
    }
}