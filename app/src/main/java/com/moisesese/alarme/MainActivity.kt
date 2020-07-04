package com.moisesese.alarme

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {

    var tabLayout: TabLayout? = null
    var viewPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //JSON FILE creation
        val jsonAlarms = this.createFolderAndFile()
        JsonData.writeAlarmTEST(jsonAlarms)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        viewPager = findViewById<ViewPager>(R.id.viewPager)

        tabLayout!!.tabGravity = TabLayout.GRAVITY_FILL

        val adapter = ViewPagerAdapter(this, supportFragmentManager)
        viewPager!!.adapter = adapter
        viewPager!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
                TODO("Not yet implemented")
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                TODO("Not yet implemented")
            }

            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager!!.currentItem = tab.position
            }
        })
        tabLayout!!.setupWithViewPager(viewPager)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun createFolderAndFile() : File{
        var folderPath : File = File(this.getExternalFilesDir(null), "AlarMe")
        if(!folderPath.exists()) folderPath.mkdirs()

        val filePath : String = "AlarmsRecorded.json"
        // create a File object for the output file
        val outputFile = File(folderPath, filePath)
        // now attach the OutputStream to filePath file object, instead of a String representation
        if(!outputFile.exists()) FileOutputStream(outputFile)
        return outputFile
    }
}
