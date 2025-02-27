package es.etg.dam.pmdm13.gym.data.remote

import com.google.gson.annotations.SerializedName

data class TiempoResponse(
    @SerializedName("title") var titulo: String,
    var today: Any)
