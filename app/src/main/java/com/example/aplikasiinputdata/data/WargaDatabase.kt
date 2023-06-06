package com.example.aplikasiinputdata.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Warga::class], version = 1, exportSchema = false)
abstract class WargaDatabase : RoomDatabase() {
    abstract fun UserDao():UserDao

    companion object{
        @Volatile
        private var INSTANCE : WargaDatabase? = null

        fun getDatabase (context: Context):WargaDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WargaDatabase::class.java,
                    "warga_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}