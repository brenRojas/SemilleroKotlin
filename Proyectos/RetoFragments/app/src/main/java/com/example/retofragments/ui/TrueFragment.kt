package com.example.retofragments.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retofragments.Adapter.CustomAdapter
import com.example.retofragments.R
import com.example.retofragments.databinding.FragmentTrueBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TrueFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TrueFragment : Fragment() {
    private var _binding: FragmentTrueBinding? = null
    private val binding get() = _binding!!
    private var param1: String? = null
    private var param2: String? = null
    val textos = arrayOf("uno","dos","tres")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTrueBinding.inflate(inflater, container, false)
        val view = binding.root
        return inflater.inflate(R.layout.fragment_true, container, false)

        val adaptador = CustomAdapter(textos)
        binding.recyclerView.adapter = adaptador
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)

        //Optimiza el tamaño del recycler en la pantalla
        binding.recyclerView.hasFixedSize()
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //val datos = DatosDao().loadLista()

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}