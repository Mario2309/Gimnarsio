package es.etg.dam.pmdm13.gym.ui.state

sealed class CodQrUIState {
    object Loading : CodQrUIState()
    data class Success(val qrCode: String) : CodQrUIState()
    data class Error(val message: String) : CodQrUIState()
}