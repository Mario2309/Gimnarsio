package es.etg.dam.pmdm13.gym

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Usuario (
    var correo: String,
    var nombre:String,
    var contrasenia: String
): Parcelable{

    override fun toString(): String {
        return "Nombre: $nombre";
    }
}