package com.arafat1419.suitmedia1.utils

import android.os.Build
import java.time.LocalDate
import java.time.format.DateTimeFormatter

object Helper {
    fun stringToDate(date: String): String {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd")).format(
                DateTimeFormatter.ofPattern("dd MMMM yyyy")
            ).toString()
        } else {
            date
        }
    }
}