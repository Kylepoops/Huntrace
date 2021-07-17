package cn.cubegarden.huntrace.world

import cn.cubegarden.huntrace.game.settings.WorldSetting
import com.onarandombox.MultiverseCore.api.Core
import org.bukkit.Bukkit
import org.bukkit.World
import org.bukkit.WorldCreator

object WorldManager {

    val currentWorldMap = hashMapOf<Int, World>()
    val MVWorldManager = (Bukkit.getServer().pluginManager.getPlugin("Multiverse-Core") as Core).mvWorldManager!!

    fun generateWorld(setting: WorldSetting, gameId: Int): World {
        val world = WorldCreator(gameId.toString()).apply {
            generateStructures(setting.generateStructures)
            setting.seed?.let { seed(it) }
        }.createWorld()!!
        currentWorldMap[gameId] = world
        MVWorldManager.addWorld(
            gameId.toString(), null, null, null, null, null
        )
        return world
    }

    fun deleteWorld(gameId: Int) {
        MVWorldManager.deleteWorld(gameId.toString())
    }
}