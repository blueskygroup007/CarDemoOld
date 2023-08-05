package com.bluesky.cardemoold.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bluesky.cardemoold.R
import com.bluesky.cardemoold.bean.Series
import com.bluesky.cardemoold.databinding.ItemSeriesBinding

class SeriesListAdapter(
    private val ctx: Context,

    ) : RecyclerView.Adapter<SeriesHolder>() {
    var mData: MutableList<Series> = mutableListOf()

    fun setData(data: List<Series>) {
        mData.clear()
        //Log.d("SeriesListAdapter-data:", data.toString())
        mData.addAll(data)
        //Log.d("SeriesListAdapter-mData:", mData.toString())
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeriesHolder {
        val inflate = LayoutInflater.from(ctx)
        val binding: ItemSeriesBinding =
            DataBindingUtil.inflate(inflate, R.layout.item_series, parent, false)
        val holder = SeriesHolder(binding.root)
        holder.binding = binding
        return holder
    }

    override fun onBindViewHolder(holder: SeriesHolder, position: Int) {
        mData.let {
            holder.binding?.series = mData[position]
        }
    }

    override fun getItemCount(): Int {
        return mData.size
    }

}

class SeriesHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var binding: ItemSeriesBinding? = null

}
