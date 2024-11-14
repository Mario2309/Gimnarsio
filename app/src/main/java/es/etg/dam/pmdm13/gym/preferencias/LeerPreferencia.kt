package es.etg.dam.pmdm13.gym.preferencias

import android.content.Context

private const val PREFERENCIAS_USUARIO = "PreferenciasUsuario"

private const val NOMBRE = "nombre"

private const val VACIO = ""

class LeerPreferencia(private val context: Context): Preferencia {
    override fun guardar(nombre: String) {
        TODO("Not yet implemented")
    }

    override fun leer(): String? {
        val sharedPref = context.getSharedPreferences(PREFERENCIAS_USUARIO, Context.MODE_PRIVATE)
        return sharedPref.getString(NOMBRE, VACIO)
    }

}