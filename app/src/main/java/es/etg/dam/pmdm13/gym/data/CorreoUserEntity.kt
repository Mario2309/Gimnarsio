package es.etg.dam.pmdm13.gym.data

import androidx.room.Embedded
import androidx.room.Relation

data class CorreoUserEntity(

    @Embedded val usuario: UserEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "usuario"
    )
    val correos: List<CorreoEntity>
)
