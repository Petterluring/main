package com.chips

data class ChipStack(private var _buyIn: Int) {
    val whites: Int = 0
    val reds: Int = 0
    val greens: Int = 0
    val blacks: Int = 0
    val purples: Int = 0
    val yellows: Int = 0
    val grays: Int = 0


    init {
        require(_buyIn > 0) {"Buy in most be larger than 0"}

    }

}