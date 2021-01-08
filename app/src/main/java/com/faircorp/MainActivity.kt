package com.faircorp

import android.content.Intent
//import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

const val WINDOW_ID_PARAM = "com.faircorp.windowname.attribute"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /** Called when the user taps the button */
    fun openWindow(view: View) {

        try {
            val windowId = findViewById<EditText>(R.id.txt_room_name).text.toString()
            val windowIdLong = windowId.toLong();
            Toast.makeText(this, "You choose $windowId", Toast.LENGTH_LONG).show()
            val intent = Intent(this, WindowActivity::class.java).apply {
                putExtra(WINDOW_ID_PARAM, windowIdLong)
            }
            startActivity(intent)
        }
        catch (e: NumberFormatException) {
            Toast.makeText(this, "Please give a valid ID", Toast.LENGTH_LONG).show()
        }
    }
}
