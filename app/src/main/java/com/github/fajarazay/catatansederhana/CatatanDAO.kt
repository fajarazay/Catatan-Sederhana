package com.github.fajarazay.catatansederhana

import androidx.lifecycle.LiveData
import androidx.room.*

/**
 * Created by FAJAR SEPTIAN on 12/07/20.
 *
 * @Author Fajar Septian
 * @Email fajarajay10@gmail.com
 * @Github https://github.com/fajarazay
 */

@Dao
interface CatatanDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(catatan: Catatan) : Long

    @Update
    fun update(catatan: Catatan) : Int

    @Delete
    fun delete (catatan: Catatan) : Int

    @Query("SELECT * from catatan WHERE idCatatan= :idCatatan")
    fun getDetailCatatan(idCatatan: Int): LiveData<Catatan>

    @Query("SELECT * from catatan")
    fun getAllDataCatatan(): LiveData<List<Catatan>>
}