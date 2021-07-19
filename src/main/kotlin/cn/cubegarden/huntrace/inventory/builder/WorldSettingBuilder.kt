package cn.cubegarden.huntrace.inventory.builder

import cn.cubegarden.huntrace.Main
import cn.cubegarden.huntrace.game.GameManager.getSettingsOrCreate
import de.themoep.inventorygui.InventoryGui
import de.themoep.inventorygui.StaticGuiElement
import org.bukkit.Difficulty
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

object WorldSettingBuilder {
    val worldGui: InventoryGui
    val difficultyGui: InventoryGui

    init {
        val guiSetup = arrayOf(
            "  d g s  "
        )

        difficultyGui = InventoryGui(Main.INSTANCE, "世界难度设置", guiSetup).apply {
            addElement(StaticGuiElement(
                'd',
                ItemStack(Material.SKELETON_SKULL),
                {
                    it.whoClicked.getSettingsOrCreate().apply {
                        worldSetting.difficulty = Difficulty.EASY
                    }
                    true
                },
                "简单模式"
            ))

            addElement(StaticGuiElement(
                'd',
                ItemStack(Material.ZOMBIE_HEAD),
                {
                    it.whoClicked.getSettingsOrCreate().apply {
                        worldSetting.difficulty = Difficulty.NORMAL
                    }
                    true
                },
                "普通模式"
            ))

            addElement(StaticGuiElement(
                's',
                ItemStack(Material.DRAGON_HEAD),
                {
                    it.whoClicked.getSettingsOrCreate().apply {
                        worldSetting.difficulty = Difficulty.HARD
                    }
                    true
                },
                "困难模式"
            ))
        }

        worldGui = InventoryGui(Main.INSTANCE, "世界生成设置", guiSetup)

        worldGui.addElement(StaticGuiElement(
            'd',
            ItemStack(Material.ZOMBIE_HEAD),
            {
                difficultyGui.show(it.whoClicked)
                true
            },
            "世界难度设置"
        ))


    }
}