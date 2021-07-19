package cn.cubegarden.huntrace.game

import org.bukkit.entity.HumanEntity
import org.bukkit.entity.Player

object GameManager {
    val settingsMap = hashMapOf<Player, HuntraceSettings>()

    fun <T: HumanEntity> T.getSettingsOrCreate(): HuntraceSettings {
        this as Player
        if (this !in settingsMap) {
            settingsMap[this] = HuntraceSettings()
        }
        return settingsMap[this]!!
    }
}