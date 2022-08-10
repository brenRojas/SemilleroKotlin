package com.wizeline.realtimestocks.ui.featuredstocks

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.wizeline.realtimestocks.stock.Stock
import com.wizeline.realtimestocks.stock.StocksGenerator
import com.wizeline.realtimestocks.stock.StocksRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FeaturedStocksViewModel : ViewModel() {

    private val repository = StocksRepository(Dispatchers.IO, StocksGenerator())

    @ExperimentalCoroutinesApi
    val stocks: LiveData<List<Stock>> = repository
        .getFeaturedStocks(delayInMillis = 10_000)
        .asLiveData()


    fun devolverLista() : List<Stock>{
        var listStock: List<Stock> = listOf()

        viewModelScope.launch {
            listStock = withContext(Dispatchers.Main){
                repository.getFeaturedStocks()
                repository.
            }
        }
        Log.d("probando", "Repositorio ${repository.getFeaturedStocks()}")
        Log.d("probando", "Lista: ${listStock}")

        return listStock
    }

    override fun onCleared() {
        repository.close()
    }
}