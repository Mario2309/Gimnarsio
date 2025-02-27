package es.etg.dam.pmdm13.gym.ui.viewmodel

import androidx.lifecycle.ViewModel
import es.etg.dam.pmdm13.gym.domain.usecase.GetPersonaUseCase
import javax.inject.Inject

class UsuarioViewModel @Inject constructor(
    private val getPersonaUseCase: GetPersonaUseCase
): ViewModel() {
}