package com.vinod.taskcorousal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.vinod.taskcorousal.databinding.ItemIndicatorBinding

class IndicatorAdapter(var selectedItem: Int = 0) :
    RecyclerView.Adapter<IndicatorAdapter.ViewHolder>() {
    inner class ViewHolder(var binding: ItemIndicatorBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(pos: Int) {
            binding.iv.visibility = if (pos == selectedItem) View.VISIBLE else View.GONE

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_indicator,
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(position)

    override fun getItemCount() = Utils.PAGES
    fun refresh(pos: Int) {
        this.selectedItem = pos
        notifyDataSetChanged()
    }
}