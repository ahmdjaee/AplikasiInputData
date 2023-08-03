package com.example.aplikasiinputdata.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WargaViewModel(application: Application):AndroidViewModel(application) {

    val readAllData: LiveData<List<Warga>>
    val repository: WargaRepository

    init {
        val userDao = WargaDatabase.getDatabase(application).UserDao()
        repository = WargaRepository(userDao)
        readAllData = repository.readAllData
    }
    fun addWarga (warga: Warga){
        viewModelScope.launch ( Dispatchers.IO ){
            repository.addWarga(warga)
        }
    }
    fun deleteWarga(warga: Warga){
        viewModelScope.launch {
            repository.deleteWarga(warga)
        }
    }

    fun updateWarga(warga: Warga){
        viewModelScope.launch {
            repository.updateWarga(warga)
        }
    }
}