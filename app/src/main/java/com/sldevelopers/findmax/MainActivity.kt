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
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var leftButton: Button
    private lateinit var rightButton: Button
    private lateinit var main: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        leftButton = findViewById(R.id.leftbutton)
        rightButton = findViewById(R.id.rightbutton)
        main = findViewById(R.id.main)

        ViewCompat.setOnApplyWindowInsetsListener(main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        assignNumbersToButtons()

        leftButton.setOnClickListener {
            val leftNum = leftButton.text.toString().toInt()
            val rightNum = rightButton.text.toString().toInt()
            if (leftNum > rightNum) {
                main.setBackgroundColor(Color.parseColor("#90EE90"))
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
            } else {
                main.setBackgroundColor(Color.parseColor("#F08080"))
                Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show()
            }
            assignNumbersToButtons()
        }

        rightButton.setOnClickListener {
            val leftNum = leftButton.text.toString().toInt()
            val rightNum = rightButton.text.toString().toInt()
            if (rightNum > leftNum) {
                main.setBackgroundColor(Color.parseColor("#90EE90"))
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
            } else {
                main.setBackgroundColor(Color.parseColor("#F08080"))
                Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show()
            }
            assignNumbersToButtons()
        }
    }

    private fun assignNumbersToButtons() {
        val leftNum = Random.nextInt(100)
        var rightNum = Random.nextInt(100)
        while (rightNum == leftNum) {
            rightNum = Random.nextInt(100)
        }
        leftButton.text = leftNum.toString()
        rightButton.text = rightNum.toString()
    }
}