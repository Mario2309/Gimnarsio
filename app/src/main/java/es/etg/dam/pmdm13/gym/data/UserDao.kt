package es.etg.dam.pmdm13.gym.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface UserDao {

    @Transaction
    @Query ("SELECT * FROM usuarios")
    suspend fun getAll(): List<CorreoUserEntity>

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(usuario: UserEntity)

    @Transaction
    @Delete
    suspend fun delete(usuario: UserEntity)
}