package com.brenda.demomvpretrofit_perros.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.brenda.demomvpretrofit_perros.R
import com.brenda.demomvpretrofit_perros.adapter.PerroAdapter
import com.brenda.demomvpretrofit_perros.databinding.FragmentDogsListBinding
import com.brenda.demomvpretrofit_perros.presenters.DogPresenter
import com.brenda.demomvpretrofit_perros.viewsListeners.DogsViewListener

class DogsListFragment : Fragment(), DogsViewListener {

    private var _binding: FragmentDogsListBinding? = null
    private val binding get() = _binding!!
    lateinit var presentador:DogPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presentador = DogPresenter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDogsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presentador.consumirListaPerros()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onGetDogListSuccess(lista: ArrayList<String>) {
        //Toast.makeText(activity, "Tam = ${lista.size}", Toast.LENGTH_SHORT).show()
        var adaptador = PerroAdapter(lista)
        binding.recyclerPerros.adapter = adaptador
        binding.recyclerPerros.layoutManager = LinearLayoutManager(activity)
    }

    override fun onGetDogListFail(mensaje: String) {
        Toast.makeText(activity, mensaje, Toast.LENGTH_SHORT).show()
    }

}