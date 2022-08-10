package com.brenda.demosharedtransitions

import android.os.Bundle
import android.transition.TransitionInflater
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.brenda.demosharedtransitions.databinding.FragmentAlbumBinding
import com.brenda.demosharedtransitions.databinding.FragmentDetalleAlbumBinding

class DetalleAlbumFragment : Fragment() {

    private var _binding: FragmentDetalleAlbumBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetalleAlbumBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

}