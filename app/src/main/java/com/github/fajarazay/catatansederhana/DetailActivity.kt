package com.github.fajarazay.catatansederhana

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    var catatanDAO: CatatanDAO? = null
    var catatan: Catatan? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //menampilkan tanda panah kiri di kiri atas sebagai navigasi kembali ke halaman sebelumnya
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val db = CatatanDatabase.getInstance(this)
        catatanDAO = db.catatanDAO()

        button_simpan.setOnClickListener {
            create()
        }
    }

    fun create() {
        //mengisi data berdasarkan dari inputan di edit text judul & isi
        val data = Catatan(
            judul = edittext_judul.text.toString(),
            isi = edittext_isi.text.toString()
        )

        //memasukkan data ke dalam database
        AsyncTask.execute{
            catatanDAO?.insert(data)
            finish()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        //menutup halaman ketika klik panah kiri yang ada di kiri atas
        finish()
        return super.onSupportNavigateUp()
    }
}
