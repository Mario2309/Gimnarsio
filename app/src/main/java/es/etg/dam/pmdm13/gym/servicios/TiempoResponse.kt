package es.etg.dam.pmdm13.gym.servicios

import com.google.gson.annotations.SerializedName

data class TiempoResponse(
    @SerializedName("title") var titulo: String,
    var today: Any)
