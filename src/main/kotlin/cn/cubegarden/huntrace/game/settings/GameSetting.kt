package cn.cubegarden.huntrace.game.settings

import cn.cubegarden.huntrace.game.HuntraceGame

interface GameSetting {
    fun applyTo(game: HuntraceGame) = game.applySettings(this)
}