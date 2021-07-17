package cn.cubegarden.huntrace.game

import cn.cubegarden.huntrace.game.settings.*

class HuntraceGame {

    lateinit var worldSetting: WorldSetting

    fun applySetting(setting: AntiCheatSetting) {
        TODO()
    }

    fun applySetting(setting: CompassSetting) {
        TODO()
    }

    fun applySetting(setting: HunterSetting) {
        TODO()
    }

    fun applySetting(setting: InventorySetting) {
        TODO()
    }

    fun applySetting(setting: SurvivorSetting) {
        TODO()
    }

    fun applySetting(setting: WorldSetting) {
        this.worldSetting = setting
    }

    fun applySettings(vararg settings: GameSetting) {
        for (setting in settings) {
            when (setting) {
                is AntiCheatSetting -> this.applySetting(setting)
                is CompassSetting -> this.applySetting(setting)
                is HunterSetting -> this.applySetting(setting)
                is InventorySetting -> this.applySetting(setting)
                is SurvivorSetting -> this.applySetting(setting)
                is WorldSetting -> this.applySetting(setting)
            }
        }
    }
}