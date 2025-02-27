package es.etg.dam.pmdm13.gym.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import es.etg.dam.pmdm13.gym.domain.usecase.ActualizarPreferenciaUseCase
import es.etg.dam.pmdm13.gym.domain.usecase.ObtenerPreferenciaUseCase

class PreferenciaViewModel(
    private val obtenerPreferenciasUseCase: ObtenerPreferenciaUseCase,
    private val actualizarPreferenciasUseCase: ActualizarPreferenciaUseCase
) : ViewModel() {

    private val _nombre = MutableLiveData<String?>()
    val nombre: LiveData<String?> get() = _nombre

    fun cargarPreferencia() {
        _nombre.value = obtenerPreferenciasUseCase()
    }

    fun guardarPreferencia(nombre: String) {
        actualizarPreferenciasUseCase(nombre)
        _nombre.value = nombre
    }
}