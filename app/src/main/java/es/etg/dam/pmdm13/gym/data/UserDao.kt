package es.etg.dam.pmdm13.gym.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    @Query ("SELECT id, nombre, correo FROM usuarios")
    suspend fun getAll(): List<UserEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(usuario: UserEntity)

    @Delete
    suspend fun delete(usuario: UserEntity)
}