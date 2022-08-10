package com.brenda.scannerqr.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import com.brenda.scannerqr.MainActivity
import com.brenda.scannerqr.R
import com.brenda.scannerqr.databinding.FragmentUrlBinding

class UrlFragment(var rc:String) : Fragment() {

    private var _binding: FragmentUrlBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUrlBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val uri = Uri.parse(rc)
        val intent =  Intent(Intent.ACTION_VIEW, uri)
        //startActivity(intent)

        binding.webView.loadUrl(rc)
        //var webSettings : WebSettings = binding.webView.settings

    }

}