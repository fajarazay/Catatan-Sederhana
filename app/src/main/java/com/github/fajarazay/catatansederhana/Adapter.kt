package com.github.fajarazay.catatansederhana

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.view.*

/**
 * Created by FAJAR SEPTIAN on 11/07/20.
 *
 * @Author Fajar Septian
 * @Email fajarajay10@gmail.com
 * @Github https://github.com/fajarazay
 */
class Adapter (val items: ArrayList<String>, val context: Context) :
    RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent, false))
    }

    override fun getItemCount(): Int {
       return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //set text nama negara
        holder.tv_country.text = items[position]
    }
}

class ViewHolder(view:View): RecyclerView.ViewHolder (view) {
    //inisialisasi view
    val tv_country = view.tv_country

}