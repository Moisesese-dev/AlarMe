package com.moisesese.alarme
import java.time.LocalDateTime

data class AlarmItem (
    val alarmHour : String,
    val alarmDays : String,
    var alarmEnable : Boolean = false
)