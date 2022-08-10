package com.joseluis.examenunouno.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.joseluis.examenunouno.R
import com.joseluis.examenunouno.config.ConfiguracionInicial.Companion.preferenciasGlobal
import com.joseluis.examenunouno.databinding.FragmentFormularioBinding
import com.joseluis.examenunouno.interfaces.FormularioInterface

class FormularioFragment() : Fragment() {

    private var _binding: FragmentFormularioBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFormularioBinding.inflate(inflater, container, false)

        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnIniciar.setOnClickListener {

            if(binding.chkSesion.isChecked){
                preferenciasGlobal.iniciarSesion(true)
            }

            //(activity as MainActivity)
            //se usa para llamar funciones de la actividad padre

            (activity as MainActivity).cambiarFragment(2,getNombre())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    fun getNombre():String{
        return binding.txtNombre.text.toString().trim()
    }


}