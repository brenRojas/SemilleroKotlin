package com.brenda.examen1.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.brenda.examen1.Dao.Constantes
import com.brenda.examen1.Dao.ImagenesDao
import com.brenda.examen1.R
import com.brenda.examen1.adapter.RecyclerAdapter
import com.brenda.examen1.databinding.FragmentRecyclerBinding
import com.brenda.examen1.model.Imagenes

class RecyclerFragment : Fragment() {

    private var _binding: FragmentRecyclerBinding? = null
    private val binding get() = _binding!!
    lateinit var datos: ArrayList<Imagenes>
    var daoPlanetas: ImagenesDao = ImagenesDao()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecyclerBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
        return inflater.inflate(R.layout.fragment_recycler, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        datos = ImagenesDao().getListImagenes()
        var adaptador = RecyclerAdapter(datos)
        binding.feedRecycler.adapter = adaptador

        binding.feedRecycler.apply {
            layoutManager = GridLayoutManager(context, 3, GridLayoutManager.VERTICAL, false)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}