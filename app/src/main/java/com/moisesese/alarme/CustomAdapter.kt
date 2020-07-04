package com.moisesese.alarme

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.Format
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter

//Sugerencia: Es probable que la clase ListAdapter te resulte útil para determinar los elementos de la lista
// que deben actualizarse cuando esta cambie.
class CustomAdapter(private val myDataSet: MutableList<AlarmItem>) :
    RecyclerView.Adapter<CustomAdapter.AdaptViewHolder>() {

    class AdaptViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var whatHour : TextView = itemView.findViewById(R.id.whatHour)
        var whatDay : TextView = itemView.findViewById(R.id.whichDays)
        var switchAlarm : CompoundButton = itemView.findViewById(R.id.switchSingleAlarm)

        fun bindAdapter(item : AlarmItem){
//            val context: Context = GlobalContext.getContext() //TODO CONTEXT
            val parser =  SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss") //Input date formate
            val formatter = SimpleDateFormat("HH:mm") //Output date formate
            whatHour.text = formatter.format(parser.parse(item.alarmHour))
            whatDay.text = item.alarmDays
            switchAlarm.isChecked = item.alarmEnable

            if(switchAlarm.isClickable){
                //TODO ENABLE ALARM
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdaptViewHolder {
        val itemView : View = LayoutInflater.from(parent.context).inflate(R.layout.single_alarm, parent, false)
        itemView.setOnClickListener(View.OnClickListener {
//            listener.onClick(itemView); //TODO INSIDE OF A ALARM (CONFIGURATION)
        })

        return AdaptViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: AdaptViewHolder, position: Int) {
        holder.bindAdapter(myDataSet[position])
    }

    override fun getItemCount() = myDataSet.size


}