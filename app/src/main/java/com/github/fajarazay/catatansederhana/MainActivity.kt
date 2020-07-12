package com.github.fajarazay.catatansederhana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //inisialisasi variabel
    var arrayCountry: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fillCountry()

        rv_country.layoutManager = LinearLayoutManager(this)
        rv_country.adapter = Adapter(arrayCountry, this)

//        val result = calculateSum(10, 2)
//        Log.d("resultCalculateSum: ", result.toString())
//
//        var isPSBB = true
//
//        if (isPSBB==true) {
//            Log.d("isPSBB: ", "Work from home")
//        }
//        else {
//            Log.d("isPSBB: ", "Work from office")
//        }

    }

    fun fillCountry(){
        arrayCountry.add("Indonesia")
        arrayCountry.add("Brazil")
        arrayCountry.add(("Jepang"))
        arrayCountry.add("Indonesia")
        arrayCountry.add("Brazil")
        arrayCountry.add(("Jepang"))
        arrayCountry.add("Indonesia")
        arrayCountry.add("Brazil")
        arrayCountry.add(("Jepang"))
        arrayCountry.add("Indonesia")
        arrayCountry.add("Brazil")
        arrayCountry.add(("Jepang"))
    }

    fun calculateSum(number1: Int, number2:Int) : Int {
        val result = number1+number2
        return result
    }
}
