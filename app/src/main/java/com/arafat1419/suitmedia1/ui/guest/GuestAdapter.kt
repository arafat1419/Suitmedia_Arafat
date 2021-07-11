package com.arafat1419.suitmedia1.ui.guest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.arafat1419.suitmedia1.data.DataGuest
import com.arafat1419.suitmedia1.databinding.ListGuestBinding
import com.arafat1419.suitmedia1.ui.home.HomeFragment
import com.arafat1419.suitmedia1.utils.Helper
import com.bumptech.glide.Glide

class GuestAdapter : RecyclerView.Adapter<GuestAdapter.ViewHolder>() {
    private val listData = ArrayList<DataGuest>()

    fun setData(data: List<DataGuest>?) {
        if (data == null) return
        this.listData.clear()
        this.listData.addAll(data)
    }

    inner class ViewHolder(private val binding: ListGuestBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: DataGuest) {
            with(binding) {
                txtGuestName.text = data.name
                txtGuestDate.text = Helper.stringToDate(data.birthdate)
                Glide.with(itemView.context)
                    .load(data.image)
                    .into(imgGuest)
                itemView.setOnClickListener {
                    val map = mapOf(
                        HomeFragment.GUEST_NAME_BUNDLE to data.name,
                        HomeFragment.GUEST_DATE_BUNDLE to data.birthdate
                    )
                    it.findNavController().previousBackStackEntry?.savedStateHandle?.set(
                        HomeFragment.GUEST_BUNDLE,
                        map
                    )
                    it.findNavController().popBackStack()
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemsDataBinding =
            ListGuestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemsDataBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int = listData.size
}