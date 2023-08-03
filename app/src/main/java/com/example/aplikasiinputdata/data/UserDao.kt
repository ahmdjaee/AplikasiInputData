package com.example.aplikasiinputdata.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {
    @Insert (onConflict = OnConflictStrategy.IGNORE)
    fun addWarga (warga: Warga)

    @Query ("SELECT * FROM table_warga ORDER BY id ASC")
    fun readAllData():LiveData<List<Warga>>

    @Delete
    suspend fun deleteWarga(warga: Warga)

    @Update
    suspend fun updateWarga(warga: Warga)

}