package com.github.fajarazay.catatansederhana

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Created by FAJAR SEPTIAN on 12/07/20.
 *
 * @Author Fajar Septian
 * @Email fajarajay10@gmail.com
 * @Github https://github.com/fajarazay
 */

@Database(entities = [Catatan::class], version = 1, exportSchema = false)
abstract class CatatanDatabase : RoomDatabase() {
    abstract  fun catatanDAO() : CatatanDAO

    companion object {
        @Volatile
        var INSTANCE : CatatanDatabase? = null

        fun getInstance(context: Context): CatatanDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    CatatanDatabase::class.java,
                    "catatan.db"
                ).allowMainThreadQueries()
                    .build()
            }
    }
}