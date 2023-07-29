package com.bluesky.cardemoold.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bluesky.cardemoold.R
import com.bluesky.cardemoold.databinding.ItemLogoBinding

/**
 *
 * @author BlueSky
 * @date 23.7.28
 * Description:
 */
open class LogoAdapter(
    var ctx: Context,
    var mData: MutableList<com.bluesky.cardemoold.bean.Result>
) : RecyclerView.Adapter<LogoAdapter.LogoHolder>() {

    val inflater = LayoutInflater.from(ctx)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LogoHolder {
        val binding: ItemLogoBinding =
            DataBindingUtil.inflate(inflater, R.layout.item_logo, parent, false)
        var holder = LogoHolder(binding.root)
        holder.binding = binding
        return holder
    }

    override fun onBindViewHolder(holder: LogoHolder, position: Int) {
        val bean = mData.get(position)
        holder.binding?.item = bean
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class LogoHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var binding: ItemLogoBinding? = null

    }
}