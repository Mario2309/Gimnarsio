package es.etg.dam.pmdm13.gym.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserEntity::class, CorreoEntity::class], version = 1)
abstract class UserDatabase: RoomDatabase() {

    abstract fun userDao(): UserDao

    abstract fun correoDao(): CorreoDao

}