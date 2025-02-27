package es.etg.dam.pmdm13.gym.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import es.etg.dam.pmdm13.gym.domain.usecase.ObtenerPreferenciaUseCase
import javax.inject.Inject

@HiltViewModel
class InicioViewModel @Inject constructor(
    private val obtenerPreferenciasUseCase: ObtenerPreferenciaUseCase
) : ViewModel() {

    private val _nombreUsuario = MutableLiveData<String?>()
    val nombreUsuario: LiveData<String?> get() = _nombreUsuario

    fun cargarNombreUsuario() {
        _nombreUsuario.value = obtenerPreferenciasUseCase()
    }
}
