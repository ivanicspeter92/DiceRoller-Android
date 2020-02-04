package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var rolledValueImageView: ImageView
    private lateinit var rolledValueTextView: TextView
    private val diceRoller = DiceRollLogic(6)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        rolledValueImageView = findViewById(R.id.rolledValueImageView)
        rolledValueTextView = findViewById(R.id.rolledValueTextView)

        setContentView(R.layout.activity_main)

        initializeRollButton()
        initializeImageView()
    }

    private fun initializeRollButton() {
        val rollButton: Button = findViewById(R.id.rollButton)
        rollButton.text = "Let's roll"
        rollButton.setOnClickListener {
            rollDice()
        }
    }

    private fun initializeImageView() {
        rolledValueImageView.setImageResource(R.drawable.empty_dice)
    }

    private fun rollDice() {
        val value = diceRoller.roll()
//        loadValueToTextView(value)
        loadValueToImageView(value)
    }

    private fun loadValueToTextView(value: Int) {
        rolledValueTextView.text = value.toString()
    }

    private fun loadValueToImageView(value: Int) {
        val resource = getDrawableResourceId(value)

        rolledValueImageView.setImageResource(resource)
    }

    private fun getDrawableResourceId(value: Int): Int {
        return when (value) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }
    }
}
