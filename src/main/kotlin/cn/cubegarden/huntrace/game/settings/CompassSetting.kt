package cn.cubegarden.huntrace.game.settings

import org.bukkit.Location

data class CompassSetting(
    val location: Location,
    val maxDistance: Int
) : GameSetting