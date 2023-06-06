package com.example.aplikasiinputdata.data

import androidx.lifecycle.LiveData

class WargaRepository (private val userDao: UserDao){
    val readAllData : LiveData<List<Warga>> = userDao.readAllData()

    suspend fun addWarga (warga: Warga){
        userDao.addWarga(warga)
    }

    suspend fun deleteWarga(warga: Warga){
        userDao.deleteWarga(warga)
    }

}