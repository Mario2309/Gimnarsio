package es.etg.dam.pmdm13.gym.ui.state

sealed class CalendarioUIState {
    object Loading : CalendarioUIState()
    data class Success(val eventos: List<String>) : CalendarioUIState()
    data class Error(val mensaje: String) : CalendarioUIState()
}
