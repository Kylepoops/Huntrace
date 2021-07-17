package cn.cubegarden.huntrace.inventory

import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.OfflinePlayer
import org.bukkit.entity.HumanEntity
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.SkullMeta

object SkullUtils {

    fun <T: HumanEntity> T.toSkull() : ItemStack {
        val item = ItemStack(Material.PLAYER_HEAD)
        val meta = item.itemMeta as SkullMeta
        meta.displayName(Component.text(this.name))
        meta.owningPlayer = this as OfflinePlayer
        item.itemMeta = meta
        return item
    }
}