package com.brenda.notificacionsybottomnav.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.NotificationCompat
import com.brenda.notificacionsybottomnav.MainActivity
import com.brenda.notificacionsybottomnav.R
import com.brenda.notificacionsybottomnav.databinding.FragmentNotificationBinding

class NotificationFragment : Fragment() {
    private var _binding: FragmentNotificationBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNotificationBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnNotificacion.setOnClickListener {
            Toast.makeText(activity, "Probando btn", Toast.LENGTH_SHORT).show()
            (activity as MainActivity).mostrarNotificacionNormal()
        }

        binding.btnNotificacionLarga.setOnClickListener {
            (activity as MainActivity).mostrarNotificacioLarga()
        }
        return view
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}