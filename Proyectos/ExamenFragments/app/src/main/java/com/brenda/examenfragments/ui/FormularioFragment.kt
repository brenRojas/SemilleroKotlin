package com.brenda.examenfragments.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.brenda.examenfragments.R
import com.brenda.examenfragments.config.ConfiguracionInicial.Companion.preferenciasGlobal
import com.brenda.examenfragments.databinding.FragmentFormularioBinding

class FormularioFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_formulario, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnIngresar.setOnClickListener {
            if(binding.checkbox.isChecked == true){
                //(activity as MainActivity).cambiarFragment("recycler")
                preferenciasGlobal.iniciarSesion(true)
            }else{
                //(activity as MainActivity).cambiarFragment("salir")
                preferenciasGlobal.iniciarSesion(false)

            }
        }

    }

}