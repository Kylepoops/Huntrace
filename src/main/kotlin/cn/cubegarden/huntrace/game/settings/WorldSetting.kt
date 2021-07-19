package cn.cubegarden.huntrace.game.settings

import org.bukkit.Difficulty

data class WorldSetting(
    var difficulty: Difficulty = Difficulty.HARD,
    var generateStructures: Boolean = true,
    var seed : Long? = null
) : GameSetting