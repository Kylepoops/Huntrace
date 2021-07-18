package cn.cubegarden.huntrace.world

import cn.cubegarden.huntrace.game.settings.WorldSetting
import com.onarandombox.MultiverseCore.api.Core
import com.onarandombox.MultiverseNetherPortals.MultiverseNetherPortals
import org.bukkit.Bukkit
import org.bukkit.PortalType
import org.bukkit.World
import org.bukkit.WorldCreator
import com.onarandombox.multiverseinventories.MultiverseInventories
import com.onarandombox.multiverseinventories.share.Sharables


object WorldManager {

    val currentWorldMap = hashMapOf<Int, World>()
    private val MVWorldManager =
        (Bukkit.getServer().pluginManager.getPlugin("Multiverse-Core") as Core).mvWorldManager!!
    private val NetherPortals =
        (Bukkit.getServer().pluginManager.getPlugin("Multiverse-NetherPortals") as MultiverseNetherPortals)
    private val inveotoriesGroupManager =
        (Bukkit.getServer().pluginManager.getPlugin("Multiverse-Inventories") as MultiverseInventories).groupManager

    fun initWorld(setting: WorldSetting, name: String): World {
        lateinit var overWorld: World

        val netherWorldName = "${name}_nether"
        val endWorldName = "${name}_the_end"

        WorldCreator(netherWorldName).apply {
            environment(World.Environment.NETHER)
            setting.seed?.let { seed(it) }
            createWorld()
        }
        WorldCreator(endWorldName).apply {
            environment(World.Environment.THE_END)
            setting.seed?.let { seed(it) }
            createWorld()
        }
        WorldCreator(name).apply {
            generateStructures(setting.generateStructures)
            setting.seed?.let { seed(it) }
            overWorld = createWorld()!!
        }

        NetherPortals.apply {
            addWorldLink(name, netherWorldName, PortalType.NETHER)
            addWorldLink(netherWorldName, name, PortalType.NETHER)

            addWorldLink(name, endWorldName, PortalType.ENDER)
            addWorldLink(endWorldName, name, PortalType.ENDER)
        }

        inveotoriesGroupManager.newEmptyGroup(name).apply {
            addWorld(name)
            addWorld(netherWorldName)
            addWorld(endWorldName)
            shares.addAll(Sharables.allOf())
            inveotoriesGroupManager.updateGroup(this@apply)
        }

        return overWorld
    }

    fun deleteWorld(name: String) {
        MVWorldManager.apply {
            deleteWorld(name)
            deleteWorld(name + "_nether")
            deleteWorld(name + "_the_end")
        }
    }
}