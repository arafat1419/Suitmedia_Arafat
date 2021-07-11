package com.arafat1419.suitmedia1.ui.event.list

import android.graphics.text.LineBreaker.JUSTIFICATION_MODE_INTER_WORD
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
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
                txtDesc.text = data.desc
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    txtDesc.justificationMode = JUSTIFICATION_MODE_INTER_WORD
                }
                Glide.with(itemView.context)
                    .load(data.image)
                    .into(imgEvent)
                val hashtagAdapter = HashtagAdapter()
                hashtagAdapter.setData(data.hashtag)

                rvHashtag.apply {
                    layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
                    setHasFixedSize(true)
                    adapter = hashtagAdapter
                }

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