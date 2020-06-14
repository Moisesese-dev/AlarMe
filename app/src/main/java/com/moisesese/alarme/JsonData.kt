package com.moisesese.alarme

import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializer
import java.io.File
import java.time.LocalDateTime


object JsonData {
    private var alarms : MutableList<AlarmItem> = ArrayList()

    fun writeAlarmTEST(jsonAlarms : File){
        var testAlarm : AlarmItem = AlarmItem(LocalDateTime.now().toString(),"M-X-F", false)
        var testAlarm2 : AlarmItem = AlarmItem(LocalDateTime.now().toString(), "M", false)
        alarms.add(testAlarm)
        alarms.add(testAlarm2)

        val gsonPretty = GsonBuilder().setPrettyPrinting().create().toJson(alarms)

        jsonAlarms.writeText(gsonPretty)
        println(jsonAlarms.readText())
    }

}