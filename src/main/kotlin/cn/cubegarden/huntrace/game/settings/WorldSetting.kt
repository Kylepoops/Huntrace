package cn.cubegarden.huntrace.game.settings

import org.bukkit.Difficulty

data class WorldSetting(
    // val newGenerator: Boolean,
    val difficulty: Difficulty,
    val generateStructures: Boolean,
    val seed : Long? = null
) : GameSetting