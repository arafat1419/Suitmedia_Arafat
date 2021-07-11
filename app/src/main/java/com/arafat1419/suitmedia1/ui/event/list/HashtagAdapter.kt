package com.arafat1419.suitmedia1.ui.event.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arafat1419.suitmedia1.R
import com.arafat1419.suitmedia1.data.DataHashtag
import com.arafat1419.suitmedia1.databinding.ListHashtagBinding

class HashtagAdapter : RecyclerView.Adapter<HashtagAdapter.ViewHolder>() {
    private val listData = ArrayList<DataHashtag>()

    fun setData(data: List<DataHashtag>?) {
        if (data == null) return
        this.listData.clear()
        this.listData.addAll(data)
    }

    inner class ViewHolder(private val binding: ListHashtagBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: DataHashtag) {
            with(binding) {
                hashtagName.text = itemView.resources.getString(R.string.hashtag, data.hashtag)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemsDataBinding =
            ListHashtagBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemsDataBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int = listData.size
}