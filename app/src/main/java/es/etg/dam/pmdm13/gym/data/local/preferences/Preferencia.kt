package es.etg.dam.pmdm13.gym.data.local.preferences

interface Preferencia{

    fun guardar(nombre: String)

    fun leer(): String?
}