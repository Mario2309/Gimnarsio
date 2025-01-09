package es.etg.dam.pmdm13.gym.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "correos")
data class CorreoEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val correo: String = "",
    val usuario: Long = 0

)

