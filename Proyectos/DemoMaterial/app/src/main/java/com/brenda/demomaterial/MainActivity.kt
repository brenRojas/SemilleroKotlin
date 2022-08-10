package com.brenda.demomaterial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import com.brenda.demomaterial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){
    lateinit var binding: ActivityMainBinding

    lateinit var arrayList_season : ArrayList<String>
    lateinit var arrayAdapter_Season : ArrayAdapter<String>
    lateinit var item : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        arrayList_season = ArrayList()
        arrayList_season.add("Winter")
        arrayList_season.add("Spring")
        arrayList_season.add("Summer")
        arrayList_season.add("Monsoon")
        arrayList_season.add("Autumn")

        arrayAdapter_Season = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, arrayList_season )
        binding.actSeasons.setAdapter(arrayAdapter_Season)
        binding.actSeasons.threshold



    }

    fun mostrar(view: android.view.View) {
        item = (binding.tilSeason.getEditText() as AutoCompleteTextView).text.toString()

        Toast.makeText(this, "$item", Toast.LENGTH_SHORT).show()
    }
}