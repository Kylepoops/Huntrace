package cn.cubegarden.huntrace.inventory.listener

import cn.cubegarden.huntrace.inventory.holder.MainSettingHolder
import org.bukkit.event.inventory.InventoryClickEvent

class MainSettingListener : HuntraceInventoryListener() {

    fun onInventoryClick(event: InventoryClickEvent) {
        if (event.inventory.holder !is MainSettingHolder) return
        TODO()
    }
}