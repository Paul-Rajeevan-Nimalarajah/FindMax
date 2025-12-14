package com.sldevelopers.findmax

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val leftbutton = findViewById<Button>(R.id.leftbutton)
        val rightbutton = findViewById<Button>(R.id.rightbutton)
        val main = findViewById<ConstraintLayout>(R.id.main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        leftbutton.setOnClickListener {
            val leftNum = leftbutton.text.toString().toInt()
            val rightNum = rightbutton.text.toString().toInt()
            if (leftNum > rightNum) {
                main.setBackgroundColor(Color.parseColor("#90EE90"))
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
            } else {
                main.setBackgroundColor(Color.parseColor("#F08080"))
                Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show()
            }
        }
        rightbutton.setOnClickListener {
            val leftNum = leftbutton.text.toString().toInt()
            val rightNum = rightbutton.text.toString().toInt()
            if (rightNum > leftNum) {
                main.setBackgroundColor(Color.parseColor("#90EE90"))
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
            } else {
                main.setBackgroundColor(Color.parseColor("#F08080"))
                Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show()
            }
        }

    }
}