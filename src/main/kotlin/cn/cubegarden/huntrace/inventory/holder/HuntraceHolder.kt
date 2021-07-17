package cn.cubegarden.huntrace.inventory.holder

import org.bukkit.inventory.Inventory
import org.bukkit.inventory.InventoryHolder

abstract class HuntraceHolder : InventoryHolder {

    override fun getInventory(): Inventory {
        throw UnsupportedOperationException()
    }
}