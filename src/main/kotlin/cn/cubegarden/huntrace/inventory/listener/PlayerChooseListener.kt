package cn.cubegarden.huntrace.inventory.listener

import cn.cubegarden.huntrace.inventory.holder.PlayerChooseHolder
import org.bukkit.event.inventory.InventoryClickEvent

class PlayerChooseListener : HuntraceInventoryListener() {

    fun onInventoryClick(event: InventoryClickEvent) {
        if (event.inventory.holder !is PlayerChooseHolder) return
        TODO()
    }
}