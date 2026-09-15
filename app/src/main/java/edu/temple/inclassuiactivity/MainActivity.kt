package edu.temple.inclassuiactivity

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val displayTextView = findViewById<TextView>(R.id.textDisplay)

        /* Step 1: Populate this array */
        val numberArray = Array(50) { i -> (i + 1) * 2 }

        /* Step 2: Create adapter to display items from array in Spinner */
        spinner.adapter = TextSizeAdapter(this, numberArray)

        /* Step 3: Change TextView's text size to the number selected in the Spinner */
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                displayTextView.textSize = numberArray[position].toFloat()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }
}