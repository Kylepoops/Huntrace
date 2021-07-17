package cn.cubegarden.huntrace.inventory.listener

import cn.cubegarden.huntrace.inventory.holder.InventorySettingHolder
import org.bukkit.event.EventHandler
import org.bukkit.event.inventory.InventoryClickEvent

class InventorySettingListener : HuntraceInventoryListener() {

    @EventHandler
    fun onInventoryClick(event: InventoryClickEvent) {
        if (event.inventory.holder !is InventorySettingHolder) return
        TODO()
    }
}