package es.etg.dam.pmdm13.gym.data.local

import es.etg.dam.pmdm13.gym.data.local.mock.PersonaProvider
import javax.inject.Inject

class PersonaRepository @Inject constructor(
    private val repository: PersonaProvider
) {
}