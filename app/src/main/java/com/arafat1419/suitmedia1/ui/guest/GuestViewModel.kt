package com.arafat1419.suitmedia1.ui.guest

import androidx.lifecycle.ViewModel
import com.arafat1419.suitmedia1.data.DataGuest
import com.arafat1419.suitmedia1.utils.DataDummy

class GuestViewModel : ViewModel() {
    fun getGuest(): List<DataGuest> = DataDummy.generateDummyGuest()
}