package com.ariefaryudisyidik.store.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ariefaryudisyidik.store.data.local.entity.Store
import com.ariefaryudisyidik.store.databinding.ItemStoreBinding

class StoreListAdapter(private val onItemClick: (Store) -> Unit) :
    ListAdapter<Store, StoreListAdapter.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemStoreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = getItem(position)
        holder.bind(data)
    }

    inner class ViewHolder(private val binding: ItemStoreBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Store) {
            binding.apply {
                tvStoreName.text = data.store_name
                tvAreaName.text = data.area_name
                tvAddress.text = data.address
                root.setOnClickListener { onItemClick(data) }
            }
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Store>() {
            override fun areItemsTheSame(oldItem: Store, newItem: Store) =
                oldItem.store_id == newItem.store_id

            override fun areContentsTheSame(oldItem: Store, newItem: Store) =
                oldItem == newItem
        }
    }
}