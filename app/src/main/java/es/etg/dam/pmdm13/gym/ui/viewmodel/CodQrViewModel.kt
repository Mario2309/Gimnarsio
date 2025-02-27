package es.etg.dam.pmdm13.gym.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import es.etg.dam.pmdm13.gym.ui.state.CodQrUIState

class CodQrViewModel : ViewModel() {
    private val _estadoQr = MutableLiveData<CodQrUIState>(CodQrUIState.Loading)
    val estadoQr: LiveData<CodQrUIState> get() = _estadoQr

    fun generarCodigoQR() {
        // Simulando generación de QR
        val qrCode = "https://miqr.com/codigo123"
        _estadoQr.value = CodQrUIState.Success(qrCode)
    }

    fun mostrarError(mensaje: String) {
        _estadoQr.value = CodQrUIState.Error(mensaje)
    }
}