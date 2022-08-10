package com.wizeline.realtimestocks.ui.featuredstocks

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.wizeline.realtimestocks.adapter.FeaturedStocksAdapter
import com.wizeline.realtimestocks.databinding.FragmentFeaturedStocksBinding
import com.wizeline.realtimestocks.stock.Stock
import kotlinx.coroutines.ExperimentalCoroutinesApi

class FeaturedStocksFragment : Fragment() {

    private var _binding: FragmentFeaturedStocksBinding? = null
    private val binding get() = _binding!!
    private val viewModel: FeaturedStocksViewModel by viewModels()

    @ExperimentalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFeaturedStocksBinding.inflate(inflater, container, false)
        viewModel.stocks.observe(viewLifecycleOwner) { stocks ->
            onStocks(stocks)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.devolverLista()
        val adapter = FeaturedStocksAdapter(viewModel.devolverLista())
        binding.recyclerStock.adapter = adapter
        binding.recyclerStock.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        }
    }

    private fun onStocks(stocks: List<Stock>) {
        Log.d("stock", "$stocks")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
