package com.game.container

import com.agents.*
import com.agents.consumable.Consumable
import com.agents.consumable.Energy
import com.agents.consumable.Strength
import com.board.BoardManager

data class Container(
    val robot: Robot,
    val wolves: List<Wolf>,
    val energyBars: List<Energy>,
    val strengthBars: List<Strength>,
    val home: Home,
    val boardManager: BoardManager
) {

    fun getDynamicAgents(): List<DynamicAgent> {
        return wolves + energyBars + strengthBars + listOf(robot)
    }

    fun getConsumables(): List<Consumable> {
        return energyBars + strengthBars
    }


}