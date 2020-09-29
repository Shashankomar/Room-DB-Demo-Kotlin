package com.roomdbdemo.ui

import CountryListModel
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.roomdbdemo.R
import java.io.Serializable

class CountryListAdapter(
    private var context: Context,
    private val countryList: List<CountryListModel>?
) :
    RecyclerView.Adapter<CountryListAdapter.CountryListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryListViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.item_country_list, parent, false)
        return CountryListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return countryList?.size ?: 0
    }

    override fun onBindViewHolder(holder: CountryListViewHolder, position: Int) {
        val countryData = countryList?.get(position)
        holder.tvCountryName?.text = countryData?.name

        holder.tvCountryDetailBtn.setOnClickListener {
            val i = Intent(context, CountryDetailActivity::class.java)
            i.putExtra("dataList", countryList?.get(position))
            context.startActivity(i)
        }
    }

    class CountryListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvCountryDetailBtn: TextView = itemView.findViewById(R.id.tv_country_detail_btn)
        var tvCountryName: TextView? = itemView.findViewById(R.id.tv_country_name)
    }
}