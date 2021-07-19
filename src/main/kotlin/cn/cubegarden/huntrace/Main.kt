package cn.cubegarden.huntrace

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {

    override fun onEnable() {
        INSTANCE = getPlugin(this::class.java)
    }

    override fun onDisable() {

    }

    companion object {
        lateinit var INSTANCE: JavaPlugin
    }
}