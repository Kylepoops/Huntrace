package cn.cubegarden.huntrace.game

class HuntraceGame(settings: HuntraceSettings) {
    val antiCheatSetting = settings.antiCheatSetting.copy()
    val compassSetting = settings.compassSetting.copy()
    val hunterSetting = settings.hunterSetting.copy()
    val survivorSetting = settings.survivorSetting.copy()
    val worldSetting = settings.worldSetting.copy()

    val playerList = settings.playerList.clone()
}