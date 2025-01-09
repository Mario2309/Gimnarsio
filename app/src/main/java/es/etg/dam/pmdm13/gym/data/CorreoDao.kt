package es.etg.dam.pmdm13.gym.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface CorreoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCorreo(correo: CorreoEntity)
}