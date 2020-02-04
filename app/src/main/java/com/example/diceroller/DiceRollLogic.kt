package com.example.diceroller

import java.util.*

class DiceRollLogic(val bound: Int) {
    var lastValue: Int = 0
        private set
    private val randomizer = Random()

    fun roll(): Int {
        lastValue = randomizer.nextInt(bound) + 1

        return lastValue
    }
}