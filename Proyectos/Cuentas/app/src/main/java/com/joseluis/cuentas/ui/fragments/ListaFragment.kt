package com.joseluis.cuentas.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.joseluis.cuentas.R
import com.joseluis.cuentas.adapters.CuentaAdapter
import com.joseluis.cuentas.database.Database
import com.joseluis.cuentas.databinding.FragmentListaBinding
import com.joseluis.cuentas.listenersui.FragmentsViewListener
import com.joseluis.cuentas.models.ClenteCuentas
import com.joseluis.cuentas.models.Cliente
import com.joseluis.cuentas.models.Cuenta
import com.joseluis.cuentas.presenters.CuentaPresenter


class ListaFragment : Fragment(),FragmentsViewListener {
    private var _binding:FragmentListaBinding? = null
    private val binding get() = _binding!!
    lateinit var adaptador: CuentaAdapter

    lateinit var presentador:CuentaPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListaBinding.inflate(inflater)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presentador = CuentaPresenter(this)
        presentador.obtenerCuentas()

        binding.btnAbriFormulario.setOnClickListener {
            //val action = ListaFragment.actionDosFragmentToUnoFragment(numero = 4)
            val action = ListaFragmentDirections.actionListaFragmentToDetailFragment(operacion = Database.OPERACION_INSERTAR)
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onGetListSuccess(lista: ArrayList<ClenteCuentas>) {
        adaptador = CuentaAdapter(lista)
        binding.recyclerCuentas.adapter = adaptador
        binding.recyclerCuentas.layoutManager = LinearLayoutManager(activity)
    }

    override fun onGetListFail(razon: String) {
        Toast.makeText(activity, razon, Toast.LENGTH_SHORT).show()
    }

    override fun onCuentaCreadaExito() {}

    override fun onCuentaCreadaError() {}
    override fun onCuentaEditadaExito() {}
    override fun onCuentaEditadaError() {}
    override fun onCuentaEliminadaExito() {}
    override fun onCuentaEliminadaFail() {}

}