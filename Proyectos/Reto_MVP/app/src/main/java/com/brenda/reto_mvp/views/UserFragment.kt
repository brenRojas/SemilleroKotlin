package com.brenda.reto_mvp.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.brenda.reto_mvp.R
import com.brenda.reto_mvp.adapter.UserAdapter
import com.brenda.reto_mvp.databinding.FragmentUserBinding
import com.brenda.reto_mvp.datos.Cuenta
import com.brenda.reto_mvp.dialog.AgregarCuentaDialog
import com.brenda.reto_mvp.dialog.DialogListener
import com.brenda.reto_mvp.presenters.CuentasPresenter

class UserFragment() : Fragment(), UserViewsListener, DialogListener {

    lateinit var presenter: CuentasPresenter
    private var _binding: FragmentUserBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = CuentasPresenter(this)
        presenter.obtenerUsuarios()

        binding.agregarCuenta.setOnClickListener {
            agregarCuenta()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun obtenerLista(usuarios: ArrayList<Cuenta>) {
        var adaptador = UserAdapter(usuarios)
        binding.recyclerUser.adapter = adaptador
        binding.recyclerUser.layoutManager = LinearLayoutManager(activity)
    }

    override fun errorObtenerLista(mensaje: String) {
        Toast.makeText(activity, mensaje, Toast.LENGTH_SHORT).show()
    }

    override fun agregarCuenta() {
        val newFragment = AgregarCuentaDialog(this)
        activity?.let { newFragment.show(it.supportFragmentManager, "dialogo") }
    }

    override fun añadirCuenta() {
        TODO("Not yet implemented")
    }

}