package cn.cubegarden.huntrace.game.settings

import org.bukkit.inventory.PlayerInventory

data class InventorySetting(
    var inventory: PlayerInventory? = null
) : GameSetting