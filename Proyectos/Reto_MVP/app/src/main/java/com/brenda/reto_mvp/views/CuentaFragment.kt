package com.brenda.reto_mvp.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.brenda.reto_mvp.R
import com.brenda.reto_mvp.adapter.UserAdapter
import com.brenda.reto_mvp.databinding.FragmentCuentaBinding
import com.brenda.reto_mvp.databinding.FragmentUserBinding
import com.brenda.reto_mvp.datos.Cuenta
import com.brenda.reto_mvp.dialog.DialogListener
import com.brenda.reto_mvp.presenters.CuentasPresenter

class CuentaFragment() : Fragment(), UserViewsListener {

    lateinit var presenter: CuentasPresenter
    private var _binding: FragmentCuentaBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCuentaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = CuentasPresenter(this)
        presenter.obtenerUsuarios()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun obtenerLista(cuenta: ArrayList<Cuenta>) {

    }

    override fun errorObtenerLista(mensaje: String) {
        TODO("Not yet implemented")
    }

}