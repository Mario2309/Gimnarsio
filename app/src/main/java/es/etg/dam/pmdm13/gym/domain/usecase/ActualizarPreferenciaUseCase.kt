package es.etg.dam.pmdm13.gym.domain.usecase

import es.etg.dam.pmdm13.gym.domain.repository.PreferenciasRepository

class ActualizarPreferenciaUseCase(private val repository: PreferenciasRepository) {
    operator fun invoke(nombre: String) {
        repository.guardarPreferencia(nombre)
    }
}
