package cn.cubegarden.huntrace.game.settings

data class SurvivorSetting(
    var inventorySetting: InventorySetting = InventorySetting()
) : PlayerSetting() {
}