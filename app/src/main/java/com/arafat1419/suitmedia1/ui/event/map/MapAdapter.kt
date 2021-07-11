package com.arafat1419.suitmedia1.ui.event.map

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arafat1419.suitmedia1.data.DataEvent
import com.arafat1419.suitmedia1.databinding.ListEventMapsBinding
import com.arafat1419.suitmedia1.ui.event.list.HashtagAdapter
import com.bumptech.glide.Glide

class MapAdapter : RecyclerView.Adapter<MapAdapter.ViewHolder>() {
    private val listData = ArrayList<DataEvent>()

    fun setData(data: List<DataEvent>?) {
        if (data == null) return
        this.listData.clear()
        this.listData.addAll(data)
    }

    inner class ViewHolder(private val binding: ListEventMapsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: DataEvent) {
            with(binding) {
                txtNameMaps.text = data.name
                Glide.with(itemView.context)
                    .load(data.image)
                    .into(imgEventMaps)
                val hashtagAdapter = HashtagAdapter()
                hashtagAdapter.setData(data.hashtag)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemsDataBinding =
            ListEventMapsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemsDataBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int = listData.size
}