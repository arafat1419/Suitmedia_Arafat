package com.arafat1419.suitmedia1.utils

import com.arafat1419.suitmedia1.R
import com.arafat1419.suitmedia1.data.DataEvent
import com.arafat1419.suitmedia1.data.DataGuest

object DataDummy {
    fun generateDummyEvents(): List<DataEvent> {
        val listEvent = ArrayList<DataEvent>()

        listEvent.add(
            DataEvent(
                1,
                R.drawable.event1,
                "Event 1",
                "2021-06-19"
            )
        )

        listEvent.add(
            DataEvent(
                2,
                R.drawable.event2,
                "Event 2",
                "2021-02-03"
            )
        )

        listEvent.add(
            DataEvent(
                3,
                R.drawable.event3,
                "Event 3",
                "2021-02-19"
            )
        )

        listEvent.add(
            DataEvent(
                4,
                R.drawable.event4,
                "Event 4",
                "2021-07-23"
            )
        )

        listEvent.add(
            DataEvent(
                5,
                R.drawable.event5,
                "Event 5",
                "2021-10-15"
            )
        )
        return listEvent
    }

    fun generateDummyGuest(): List<DataGuest> {
        val listEvent = ArrayList<DataGuest>()

        listEvent.add(
            DataGuest(
                1,
                R.drawable.ic_guest,
                "Andi",
                "2014-01-01"
            )
        )

        listEvent.add(
            DataGuest(
                2,
                R.drawable.ic_guest,
                "Budi",
                "2014-02-02"
            )
        )

        listEvent.add(
            DataGuest(
                3,
                R.drawable.ic_guest,
                "Charlie",
                "2014-03-03"
            )
        )

        listEvent.add(
            DataGuest(
                4,
                R.drawable.ic_guest,
                "Dede",
                "2014-06-06"
            )
        )

        listEvent.add(
            DataGuest(
                5,
                R.drawable.ic_guest,
                "Joko",
                "2014-02-12"
            )
        )

        return listEvent
    }
}