package com.example.floweradvisor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val findFlowerButton = findViewById<Button>(R.id.bFindFlowers)

        findFlowerButton.setOnClickListener{
            val spinner = findViewById<Spinner>(R.id.spinner)
            val color = spinner.selectedItem.toString()
            val flowers = getFlowers(color)
            var flowersString = ""
            for(flower in flowers) {
                flowersString = flowersString + flower + "\n"
            }
            val flowersTextView = findViewById<TextView>(R.id.tv)
            flowersTextView.text = flowersString
        }
    }

    fun getFlowers(color: String) : List<String> {
        return when (color) {
            "White" -> listOf("Lily", "Daisy")
            "Red" -> listOf("Rose", "Tulip")
            "Orange" -> listOf("Marigold")

            else -> listOf("not found")
        }
    }
}