package es.etg.dam.pmdm13.gym.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Usuario (
    var correo: String,
    var contrasenia: String,
    var nombre:String,
): Parcelable{

    override fun toString(): String {
        return "Nombre: $nombre";
    }
}