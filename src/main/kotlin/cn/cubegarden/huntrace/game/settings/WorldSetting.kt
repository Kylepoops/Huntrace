package cn.cubegarden.huntrace.game.settings

import org.bukkit.Difficulty

data class WorldSetting(
    val newGenerator: Boolean,
    val difficulty: Difficulty
) : GameSetting