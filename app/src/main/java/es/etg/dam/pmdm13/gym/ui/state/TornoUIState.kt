package es.etg.dam.pmdm13.gym.ui.state

sealed class TornoUIState {
    object MostrarCalendario : TornoUIState()
    object MostrarQR : TornoUIState()
}