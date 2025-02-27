package es.etg.dam.pmdm13.gym.domain.usecase

import es.etg.dam.pmdm13.gym.data.local.PersonaRepository
import javax.inject.Inject

class GetPersonaUseCase @Inject constructor(
    private val repository: PersonaRepository
) {
}