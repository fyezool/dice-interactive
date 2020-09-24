package com.forkbomb.dice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
//import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        //Do a dice roll when the app starts
        rollDice()
    }

    /*
    * Roll the dice and update the screen with results
    *
    * */
    private fun rollDice() {
        //create new dice objects with 6 sides and roll the dice
        val dice = Dice(6)
        val diceRoll = dice.roll()

        //find imageview in layout
        val diceImage: ImageView = findViewById(R.id.imageView)

        //Determine which image using resource id
        val drawableResource = when (diceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            4 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        //find proper image according to conditional statement
        diceImage.setImageResource(drawableResource)

        //update content description
        diceImage.contentDescription = diceRoll.toString()
    }
}

class Dice(val numSides: Int /* make numsides as private*/) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}