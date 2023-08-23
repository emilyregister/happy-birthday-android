package com.example.happybirthday

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        logging()
        // Creating a purposeful crash
        division()

        val name = "Android"
        val birthdayNameText : TextView = findViewById(R.id.happyBirthdayText)
        birthdayNameText.text = getString(R.string.happy_birthday_text, name)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        val numSides = 100
        val dice = Dice(numSides)
        val diceRoll = dice.roll()
        val resultTextView : TextView = findViewById(R.id.ageText)
        resultTextView.text = diceRoll.toString()

        val ageTextView : TextView = findViewById(R.id.ageResultText)
        val ageImage : ImageView = findViewById(R.id.resultImage)

        if (diceRoll > numSides/2) {
            ageTextView.text = getString(R.string.old_text)
            ageImage.setImageResource(R.drawable.old_man_light_skin_tone)
        } else {
            ageTextView.text = getString(R.string.young_text)
            ageImage.setImageResource(R.drawable.boy_medium_light_skin_tone)
        }
    }

    private fun logging() {
        Log.v(TAG, "Hello World!")
    }

    private fun division() {
        val numerator = 60
        var denominator = 4
        repeat(5) {
            Log.v(TAG, "${numerator/denominator}")
            denominator--
        }
    }
}

class Dice(private val numSides: Int) {

    fun roll() : Int {
        return (1..numSides).random()
    }
}