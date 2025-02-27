package es.etg.dam.pmdm13.gym.domain.repository

interface PreferenciasRepository {
    fun guardarPreferencia(nombre: String)
    fun obtenerPreferencia(): String?
}
