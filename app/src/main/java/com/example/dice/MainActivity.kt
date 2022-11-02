package com.example.dice


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

/**
 * The main activity allows the user to roll a dice and view the result
 * in the emulator.
 */

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener { rollDice() }


    }

    /**
     * This method rolls the dice and updates the textview with the result of precis the button.
     */

    private fun rollDice() {
        // Creates a new dice with 6 sides
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Finds the imageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)

        // Finds the ID of the dices when rolled
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // Updates the ImageView with the drawable ID
        diceImage.setImageResource(drawableResource)

        // Updates the content
        diceImage.contentDescription = diceRoll.toString()
    }

    class Dice(val numSides: Int) {

        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}


