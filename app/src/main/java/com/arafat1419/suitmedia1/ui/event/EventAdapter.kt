package com.arafat1419.suitmedia1.ui.event

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.arafat1419.suitmedia1.data.DataEvent
import com.arafat1419.suitmedia1.databinding.ListEventBinding
import com.arafat1419.suitmedia1.ui.home.HomeFragment
import com.arafat1419.suitmedia1.utils.Helper
import com.bumptech.glide.Glide

class EventAdapter : RecyclerView.Adapter<EventAdapter.ViewHolder>() {
    private val listData = ArrayList<DataEvent>()

    fun setData(data: List<DataEvent>?) {
        if (data == null) return
        this.listData.clear()
        this.listData.addAll(data)
    }

    inner class ViewHolder(private val binding: ListEventBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: DataEvent) {
            with(binding) {
                txtEventName.text = data.name
                txtEventDate.text = Helper.stringToDate(data.date)
                Glide.with(itemView.context)
                    .load(data.image)
                    .into(imgEvent)
                itemView.setOnClickListener {
                    it.findNavController().previousBackStackEntry?.savedStateHandle?.set(
                        HomeFragment.EVENT_NAME_BUNDLE,
                        data.name
                    )
                    it.findNavController().popBackStack()
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemsDataBinding =
            ListEventBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemsDataBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int = listData.size
}