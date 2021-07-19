package cn.cubegarden.huntrace.game

import cn.cubegarden.huntrace.game.settings.*
import org.bukkit.entity.Player

class HuntraceSettings {
    val antiCheatSetting: AntiCheatSetting = AntiCheatSetting()
    val compassSetting: CompassSetting = CompassSetting()
    val hunterSetting: HunterSetting = HunterSetting()
    val survivorSetting: SurvivorSetting = SurvivorSetting()
    val worldSetting: WorldSetting = WorldSetting()

    val playerList = arrayListOf<Player>()

}