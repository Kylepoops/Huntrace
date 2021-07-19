package cn.cubegarden.huntrace.inventory.builder

import cn.cubegarden.huntrace.Main
import de.themoep.inventorygui.GuiElement
import de.themoep.inventorygui.InventoryGui
import de.themoep.inventorygui.StaticGuiElement
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

object MainSettingBuilder {
    lateinit var gui: InventoryGui
    init {
        val guiSetup = arrayOf(
            "abcadefga",
            "nnnnnnnnn",
            " h i j k "
        )
        gui = InventoryGui(Main.INSTANCE, "追杀生存", guiSetup)

        gui.addElement(StaticGuiElement(
            'h',
            ItemStack(Material.GRASS_BLOCK),
            1,
            GuiElement.Action {
                click ->
                TODO()
                return@Action true
            },
            "打开世界设置"
        ))
    }
}