package com.example.retofragments.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.retofragments.ConfiguracionInicial.Companion.preferenciasGlobal
import com.example.retofragments.MainActivity
import com.example.retofragments.R
import com.example.retofragments.databinding.FragmentFormularioBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FormularioFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FormularioFragment() : Fragment() {

    private var _binding: FragmentFormularioBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }


        //Guardar y Recuperar información
        //sharedPref = getSharedPreferences(
          //  Constantes.BASE_DATOS_KEY, Context.MODE_PRIVATE)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFormularioBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
        return inflater.inflate(R.layout.fragment_formulario, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnIngresar.setOnClickListener {
            if(binding.checkbox.isChecked == true){
                    preferenciasGlobal.iniciarSesion(true)
                //(activity as MainActivity).cambiarFragment(true)
            }else{
                    preferenciasGlobal.iniciarSesion(false)
                //(activity as MainActivity).cambiarFragment(false)
            }
        }

    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FormularioFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FormularioFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}