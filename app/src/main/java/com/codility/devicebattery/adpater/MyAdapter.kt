package com.codility.devicebattery.adpater

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.codility.devicebattery.Model
import com.codility.devicebattery.R

/**
 * Created by Govind on 1/12/2018.
 */
class MyAdapter(private val itemList: List<Model>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(itemList.get(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.item, parent, false))
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(model: Model) {
            val tvKey = itemView.findViewById<TextView>(R.id.tvKey)
            val tvValue = itemView.findViewById<TextView>(R.id.tvValue)

            tvKey.text = model.key
            tvValue.text = model.value
        }
    }
}