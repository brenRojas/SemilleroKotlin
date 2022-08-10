package com.joseluis.examenunouno.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.joseluis.examenunouno.R
import com.joseluis.examenunouno.adaptadores.CustomAdapter
import com.joseluis.examenunouno.databinding.FragmentFormularioBinding
import com.joseluis.examenunouno.databinding.FragmentListaBinding


class ListaFragment : Fragment() {

    lateinit var adaptador: CustomAdapter
    private var _binding: FragmentListaBinding? = null
    private val binding get() = _binding!!
    val textos = arrayOf<String>("Uno","Dos","Tres","Cuatro","Cinco","Seis","Siete","Ocho","Nueve","Cien")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListaBinding.inflate(inflater, container, false)
        val view = binding.root

        adaptador = CustomAdapter(textos)
        binding.recyclerTextos.adapter = adaptador
        binding.recyclerTextos.layoutManager = LinearLayoutManager(activity)
        binding.recyclerTextos.hasFixedSize()
        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}