package com.moisesese.alarme
import java.util.*

data class AlarmItem (
    val alarmHour : String,
    val alarmDays : String,
    var alarmEnable : Boolean = false,
    val id : UUID = UUID.randomUUID()
)