package com.vinod.taskcorousal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.vinod.taskcorousal.databinding.ItemContentBinding

class ItemsAdapter(var list: MutableList<String>) :
    RecyclerView.Adapter<ItemsAdapter.ViewHolder>() {
    inner class ViewHolder(var binding: ItemContentBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(pos: Int) {
            binding.tv.text = list[pos]
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_content,
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(position)

    override fun getItemCount() = list.size

    fun refresh(list: MutableList<String>) {
        this.list = list
        notifyDataSetChanged()
    }


}