package com.github.fajarazay.catatansederhana

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by FAJAR SEPTIAN on 12/07/20.
 *
 * @Author Fajar Septian
 * @Email fajarajay10@gmail.com
 * @Github https://github.com/fajarazay
 */

@Entity (tableName = "catatan")
data class Catatan (
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "idCatatan")
    var idCatatan: Int = 0,
    val judul: String,
    val isi: String
)