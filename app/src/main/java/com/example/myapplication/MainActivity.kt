package com.example.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button);
        rollButton.setOnClickListener {
            val toast = Toast.makeText(this, "Dice rolled!", Toast.LENGTH_SHORT);
            toast.show();
            rollDice()
//            val resultTextView: TextView = findViewById(R.id.textView)
//            resultTextView.text = "6"
        }
    }

    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()
        // Update the screen with the dice roll
        val resultTextView: TextView = findViewById(R.id.textView)
        var diceImage: ImageView = findViewById(R.id.imageView)
        resultTextView.text = diceRoll.toString()
        val drawableResource = when (diceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()
    }
}

class Dice(val Numsides: Int) {
    fun roll(): Int {
        return (1..Numsides).random()
    }
}