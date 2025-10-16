package com.example.lab6.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab6.R

class ItemAdapter(
    private val items: List<String>,
    private val clickListener: (Int, String) -> Unit
) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemTitle: TextView = itemView.findViewById(R.id.tvItemTitle)
        val itemDesc: TextView = itemView.findViewById(R.id.tvItemDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemTitle.text = items[position]
        holder.itemDesc.text = "Короткий опис для ${items[position]}"
        holder.itemView.setOnClickListener {
            clickListener(position, items[position])
        }
    }

    override fun getItemCount(): Int = items.size
}