package com.moisesese.alarme

import com.google.gson.GsonBuilder
import java.io.File
import java.time.LocalDateTime


object JsonData {
    private var alarms : MutableList<AlarmItem> = ArrayList()

    fun returnSomeAlarms() : MutableList<AlarmItem>{
        var testAlarm : AlarmItem = AlarmItem(LocalDateTime.now().toString(),"M-X-F", false)
        var testAlarm2 : AlarmItem = AlarmItem(LocalDateTime.now().toString(), "M", false)
        alarms.add(testAlarm)
        alarms.add(testAlarm2)
        return alarms
    }
    fun writeAlarmTEST(jsonAlarms : File){

        val alarms = returnSomeAlarms()
        val gsonPretty = GsonBuilder().setPrettyPrinting().create().toJson(alarms)

        jsonAlarms.writeText(gsonPretty)
    }

}