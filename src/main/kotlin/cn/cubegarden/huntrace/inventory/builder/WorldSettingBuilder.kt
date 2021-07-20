package cn.cubegarden.huntrace.inventory.builder

import cn.cubegarden.huntrace.Main
import cn.cubegarden.huntrace.game.GameManager.getSettingsOrCreate
import de.themoep.inventorygui.GuiStateElement
import de.themoep.inventorygui.InventoryGui
import de.themoep.inventorygui.StaticGuiElement
import net.wesjd.anvilgui.AnvilGUI
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

        worldGui.apply {
            addElement(StaticGuiElement(
                'd',
                ItemStack(Material.ZOMBIE_HEAD),
                {
                    difficultyGui.show(it.whoClicked)
                    true
                },
                "世界难度设置"
            ))

            addElement(GuiStateElement(
                'g',
                GuiStateElement.State(
                    {
                        it.event.whoClicked.getSettingsOrCreate().apply {
                            worldSetting.generateStructures = true
                        }
                    },
                    "generateStructures",
                    ItemStack(Material.EMERALD_BLOCK),
                    "生成建筑"
                ),
                GuiStateElement.State(
                    {
                        it.event.whoClicked.getSettingsOrCreate().apply {
                            worldSetting.generateStructures = false
                        }
                    },
                    "noGenerateStructures",
                    ItemStack(Material.REDSTONE_BLOCK),
                    "不生成建筑"
                )
            ))

            addElement(StaticGuiElement(
                's',
                ItemStack(Material.WHEAT_SEEDS),
                {
                    val builder = AnvilGUI.Builder()
                    builder.itemLeft(ItemStack(Material.WHEAT_SEEDS))
                    builder.onComplete { player, input ->
                        lateinit var result: AnvilGUI.Response
                        player.getSettingsOrCreate().runCatching {
                            worldSetting.seed = input.toLong()
                            result = AnvilGUI.Response.close()
                        }.onFailure {
                            result = AnvilGUI.Response.text("格式有误")
                        }
                        return@onComplete result
                    }
                    true
                },
                "设置种子"
            ))
        }


    }
}