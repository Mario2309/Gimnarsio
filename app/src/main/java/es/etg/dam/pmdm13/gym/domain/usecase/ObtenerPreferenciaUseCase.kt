package es.etg.dam.pmdm13.gym.domain.usecase

import es.etg.dam.pmdm13.gym.domain.repository.PreferenciasRepository

class ObtenerPreferenciaUseCase(private val repository: PreferenciasRepository) {
    operator fun invoke(): String? {
        return repository.obtenerPreferencia()
    }
}
