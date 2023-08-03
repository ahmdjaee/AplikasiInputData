package com.example.aplikasiinputdata.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "table_warga")
data class Warga(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val namaWarga :String,
    val keterangan : String,
//    val tanggalIuran : String,
    val UangIuran : Int

):Parcelable
