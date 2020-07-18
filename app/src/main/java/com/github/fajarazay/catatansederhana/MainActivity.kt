package com.github.fajarazay.catatansederhana

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.facebook.stetho.Stetho
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //inisialisasi variabel
    var arrayCountry: ArrayList<String> = ArrayList()
    var catatanDAO: CatatanDAO? = null
    private lateinit  var adapter : Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //untuk melihat isi database
        // kalo udah dirunning
        //buka chrome://inspect/#devices
        //pilih inspect - resources
        //
        Stetho.initializeWithDefaults(this)

        //fungsinya untuk membuat database
        //ketika pertama kali aplikasi dijalankan
        val db = CatatanDatabase.getInstance(this)
        catatanDAO = db.catatanDAO()

        adapter = Adapter()


        rv_country.layoutManager = LinearLayoutManager(this)
        rv_country.adapter = adapter

        button_add.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        catatanDAO?.getAllDataCatatan()?.observe(this, catatanObserver)
    }

     val catatanObserver: Observer<List<Catatan>> by lazy {
        Observer<List<Catatan>> { catatan ->
            adapter?.setCatatan(catatan)
        }
    }
}
