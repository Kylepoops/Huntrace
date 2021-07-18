package cn.cubegarden.huntrace.world

import cn.cubegarden.huntrace.game.settings.WorldSetting
import com.onarandombox.MultiverseCore.api.Core
import com.onarandombox.MultiverseNetherPortals.MultiverseNetherPortals
import org.bukkit.Bukkit
import org.bukkit.PortalType
import org.bukkit.World
import org.bukkit.WorldCreator

object WorldManager {

    val currentWorldMap = hashMapOf<Int, World>()
    private val MVWorldManager = (Bukkit.getServer().pluginManager.getPlugin("Multiverse-Core") as Core).mvWorldManager!!
    private val NetherPortals = (Bukkit.getServer().pluginManager.getPlugin("Multiverse-NetherPortals")
            as MultiverseNetherPortals)

    fun generateWorld(setting: WorldSetting, name: String): World {
        lateinit var overWorld: World
        WorldCreator(name + "_nether").apply {
            environment(World.Environment.NETHER)
            setting.seed?.let { seed(it) }
        }
        WorldCreator(name + "_the_end").apply {
            environment(World.Environment.THE_END)
            setting.seed?.let { seed(it) }
        }
        WorldCreator(name).run {
            generateStructures(setting.generateStructures)
            setting.seed?.let { seed(it) }
            overWorld = createWorld()!!
        }

        NetherPortals.addWorldLink(name, name + "_nether", PortalType.NETHER)
        NetherPortals.addWorldLink(name + "_nether", name, PortalType.NETHER)

        NetherPortals.addWorldLink(name, name + "_the_end", PortalType.ENDER)
        NetherPortals.addWorldLink(name + "_the_end", name, PortalType.ENDER)

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