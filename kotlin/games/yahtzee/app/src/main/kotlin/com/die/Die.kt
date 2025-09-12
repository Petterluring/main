package com.die

import kotlin.random.Random

class Die(
    val minValue: Int,
    val maxValue: Int
) {

    private var _currentValue: Int = minValue

    var currentValue: Int
        get() = _currentValue
        set(value) {
            require(value in minValue ..maxValue) {
                "Value must be in range of $minValue<= v <= $maxValue"
            }
        this._currentValue = value
        }

    fun roll(): Int {
        this._currentValue = Random.nextInt(maxValue + 1 - minValue) + minValue
        return _currentValue
    }
}