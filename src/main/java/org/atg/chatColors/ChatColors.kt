package org.atg.chatColors

import org.bukkit.plugin.java.JavaPlugin

class ChatColors : JavaPlugin() {

    override fun onEnable() {
        server.pluginManager.registerEvents(ChatListener(), this)
    }

}