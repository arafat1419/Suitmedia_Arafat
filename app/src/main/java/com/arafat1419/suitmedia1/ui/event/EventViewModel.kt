package com.arafat1419.suitmedia1.ui.event

import androidx.lifecycle.ViewModel
import com.arafat1419.suitmedia1.data.DataEvent
import com.arafat1419.suitmedia1.utils.DataDummy

class EventViewModel : ViewModel() {
    fun getEvent(): List<DataEvent> = DataDummy.generateDummyEvents()
}