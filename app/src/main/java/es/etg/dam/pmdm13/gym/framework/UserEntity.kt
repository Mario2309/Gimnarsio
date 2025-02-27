package es.etg.dam.pmdm13.gym.framework

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "usuarios")
data class UserEntity(

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var nombre:String = ""

)
