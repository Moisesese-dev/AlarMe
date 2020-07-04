package com.moisesese.alarme

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import java.util.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    private lateinit var v: View

    private var position = 0
    private lateinit var layout_message: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_first, container, false)
//        position = requireArguments().getInt("position",0)

        layout_message = v.findViewById(R.id.classicListAlarms) as RecyclerView

        getClassicAlarms(JsonData.returnSomeAlarms())
        /*fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }*/
        return v
    }

    private fun getClassicAlarms(alarms : MutableList<AlarmItem>){

        if(alarms.size > 0){
            layout_message.apply {
                // use this setting to improve performance if you know that changes
                // in content do not change the layout size of the RecyclerView
                setHasFixedSize(true)

                // use a linear layout manager
                layoutManager = LinearLayoutManager(activity?.application, LinearLayoutManager.VERTICAL, false)

                // specify an viewAdapter
                adapter = CustomAdapter(alarms)

                itemAnimator = DefaultItemAnimator()
            }
        }
    }

}
