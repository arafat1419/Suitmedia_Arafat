package com.arafat1419.suitmedia1.data

import com.google.android.gms.maps.model.LatLng

data class DataEvent(
    val id: Int,
    val hashtag: List<DataHashtag>,
    val image: Int,
    val desc: String,
    val name: String,
    val date: String,
    val latLng: LatLng
)

data class DataHashtag(
    val hashtag: String
)
