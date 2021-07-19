package cn.cubegarden.huntrace.game.settings

data class HunterSetting(
    var inventorySetting: InventorySetting = InventorySetting()
) : PlayerSetting()