package es.etg.dam.pmdm13.gym.data.repository

import es.etg.dam.pmdm13.gym.data.local.preferences.Preferencia
import es.etg.dam.pmdm13.gym.domain.repository.PreferenciasRepository

class PreferenciaRepositoryImpl(private val preferencias: Preferencia) : PreferenciasRepository {

    override fun guardarPreferencia(nombre: String) {
        preferencias.guardar(nombre)
    }

    override fun obtenerPreferencia(): String? {
        return preferencias.leer()
    }
}
