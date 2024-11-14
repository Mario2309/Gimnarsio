package es.etg.dam.pmdm13.gym.preferencias

interface Preferencia{

    fun guardar(nombre: String)

    fun leer(): String?
}