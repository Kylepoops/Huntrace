package cn.cubegarden.huntrace.inventory.listener

import cn.cubegarden.huntrace.inventory.holder.EnchantSettingHolder
import org.bukkit.event.EventHandler
import org.bukkit.event.inventory.InventoryClickEvent

class EnchantSettingListener : HuntraceInventoryListener() {

    @EventHandler
    fun onInventoryClick(event: InventoryClickEvent) {
        if (event.inventory.holder !is EnchantSettingHolder) return
        TODO()
    }
}