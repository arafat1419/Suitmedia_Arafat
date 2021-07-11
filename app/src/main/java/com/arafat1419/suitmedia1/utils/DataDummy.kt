package com.arafat1419.suitmedia1.utils

import com.arafat1419.suitmedia1.R
import com.arafat1419.suitmedia1.data.DataEvent
import com.arafat1419.suitmedia1.data.DataGuest
import com.arafat1419.suitmedia1.data.DataHashtag
import com.google.android.gms.maps.model.LatLng

object DataDummy {
    fun generateDummyEvents(): List<DataEvent> {
        val listEvent = ArrayList<DataEvent>()

        listEvent.add(
            DataEvent(
                1,
                listOf(
                    DataHashtag("nutricia"),
                    DataHashtag("highlight3")
                ),
                R.drawable.event1,
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
                "Event 1",
                "2021-06-19",
                LatLng(-0.8993294,119.8801412)
            )
        )

        listEvent.add(
            DataEvent(
                2,
                listOf(
                    DataHashtag("nutricia")
                ),
                R.drawable.event2,
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
                "Event 2",
                "2021-02-03",
                LatLng(-0.8841971,119.875336)
            )
        )

        listEvent.add(
            DataEvent(
                3,
                listOf(
                    DataHashtag("nutricia"),
                    DataHashtag("highlight3"),
                    DataHashtag("event")
                ),
                R.drawable.event3,
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
                "Event 3",
                "2021-02-19",
                LatLng(-0.8767828,119.883152)
            )
        )

        listEvent.add(
            DataEvent(
                4,
                listOf(
                    DataHashtag("event")
                ),
                R.drawable.event4,
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
                "Event 4",
                "2021-07-23",
                LatLng(-0.8874165,119.876035)
            )
        )

        listEvent.add(
            DataEvent(
                5,
                listOf(
                    DataHashtag("highlight3")
                ),
                R.drawable.event5,
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
                "Event 5",
                "2021-10-15",
                LatLng(-0.8973748,119.8776504)
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