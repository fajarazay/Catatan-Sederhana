package com.github.fajarazay.catatansederhana

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    var catatanDAO: CatatanDAO? = null
    var catatan: Catatan? = null
    var idCatatan = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //menampilkan tanda panah kiri di kiri atas sebagai navigasi kembali ke halaman sebelumnya
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val db = CatatanDatabase.getInstance(this)
        catatanDAO = db.catatanDAO()

        idCatatan = intent.getIntExtra("idCatatan", 0)

        if (idCatatan!=0) {
            catatanDAO?.getDetailCatatan(idCatatan)?.observe(this, catatanObserver )
        }
        button_simpan.setOnClickListener {
            if (idCatatan==0){
                create()
            }
            else {
                update()
            }
        }
    }

    val catatanObserver: Observer<Catatan> by lazy {
        Observer<Catatan> {catatan->
            if (catatan!=null) {
                edittext_judul.setText(catatan.judul)
                edittext_isi.setText( catatan.isi)
            }
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

    fun update() {
        //isi data
        val data = Catatan(
            idCatatan = idCatatan,
            judul = edittext_judul.text.toString(),
            isi = edittext_isi.text.toString()
        )
        AsyncTask.execute{
            catatanDAO?.update(data)
            finish()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.action_delete_notes) {
            delete()
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        if (idCatatan!=0) {
            //untuk menampilkan icon hapus
            menuInflater.inflate(R.menu.menu_detail, menu)
        }
        return super.onCreateOptionsMenu(menu)
    }

    fun delete(){
        val data = Catatan(
            idCatatan = idCatatan,
            judul = edittext_judul.text.toString(),
            isi = edittext_isi.text.toString()
        )
        AsyncTask.execute {
            catatanDAO?.delete(data)
            finish()
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        //menutup halaman ketika klik panah kiri yang ada di kiri atas
        finish()
        return super.onSupportNavigateUp()
    }
}
