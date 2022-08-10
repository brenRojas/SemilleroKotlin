package com.brenda.demosharedtransitions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.brenda.demosharedtransitions.databinding.FragmentAlbumBinding

class AlbumFragment : Fragment() {

    private var _binding:FragmentAlbumBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAlbumBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imgAlbum.setOnClickListener {
            val extras = FragmentNavigatorExtras(binding.imgAlbum to "zoom")
            findNavController().navigate(R.id.detalleAlbumFragment, null, null, extras)
        }
    }
}