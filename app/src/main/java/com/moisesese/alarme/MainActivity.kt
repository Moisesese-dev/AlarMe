package com.moisesese.alarme

import android.os.Bundle
import android.os.Environment
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.google.gson.Gson

import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        val jsonAlarms = this.createFolderAndFile()
        JsonData.writeAlarmTEST(jsonAlarms)
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
