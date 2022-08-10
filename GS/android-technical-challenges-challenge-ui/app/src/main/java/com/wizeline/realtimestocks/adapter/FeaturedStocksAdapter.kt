package com.wizeline.realtimestocks.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wizeline.realtimestocks.R
import com.wizeline.realtimestocks.stock.Stock

class FeaturedStocksAdapter(private var dataSet: List<Stock>) :
    RecyclerView.Adapter<FeaturedStocksAdapter.ViewHolder>(){

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.featured_stocks_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.enlazarItem(dataSet[position])
    }

    override fun getItemCount() = dataSet.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val textPrice       : TextView
        val textTicker      : TextView
        val textCompanyName : TextView


        init {
            textPrice = view.findViewById(R.id.price)
            textTicker = view.findViewById(R.id.ticker)
            textCompanyName = view.findViewById(R.id.companyName)
        }

        fun enlazarItem(stock: Stock) {

            textPrice.text = stock.price.toString()
            textTicker.text = stock.ticker
            textCompanyName.text = stock.companyName

        }
    }


}
