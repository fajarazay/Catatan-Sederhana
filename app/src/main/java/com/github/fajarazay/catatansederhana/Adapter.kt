package com.github.fajarazay.catatansederhana

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.view.*

/**
 * Created by FAJAR SEPTIAN on 11/07/20.
 *
 * @Author Fajar Septian
 * @Email fajarajay10@gmail.com
 * @Github https://github.com/fajarazay
 */
class Adapter  :
    RecyclerView.Adapter<ViewHolder>() {

    var listCatatan = ArrayList<Catatan>()


    fun setCatatan(catatan: List<Catatan>?) {
        if (catatan == null) return
        this.listCatatan.clear()
        this.listCatatan.addAll(catatan)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false))
    }

    override fun getItemCount(): Int {
       return listCatatan.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //set data catatan
        // judul & isi
        holder.tv_judul.text = listCatatan[position].judul
        holder.tv_isi.text = listCatatan[position].isi
        holder.cv_item_catatan.setOnClickListener {
            //pindah ke halaman detail
            val intent = Intent(it.context, DetailActivity::class.java)
            intent.putExtra("idCatatan", listCatatan[position].idCatatan)
            it.context.startActivity(intent)
        }
    }
}

class ViewHolder(view:View): RecyclerView.ViewHolder (view) {
    //inisialisasi view
    val tv_judul = view.tv_judul
    val tv_isi = view.tv_isi
    val cv_item_catatan = view.cv_item_catatan

}