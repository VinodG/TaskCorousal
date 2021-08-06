package com.vinod.taskcorousal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.vinod.taskcorousal.databinding.ItemIndicatorBinding
import com.vinod.taskcorousal.databinding.ItemViewPagerBinding

class ImagesAdapter(var selectedItem: Int = 0) :
    RecyclerView.Adapter<ImagesAdapter.ViewHolder>() {
    class ViewHolder(var binding: ItemViewPagerBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(pos: Int) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_view_pager,
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(position)

    override fun getItemCount() = Utils.PAGES
}