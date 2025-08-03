package org.atg.chatColors

import io.papermc.paper.event.player.AsyncChatEvent
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import java.util.regex.Pattern

class ChatListener : Listener {

    private val colorsPattern : Pattern = Pattern.compile("[&§][0-9a-fk-or]|&#([0-9a-fA-F]{6})")

    private val componentSerializer : LegacyComponentSerializer = LegacyComponentSerializer.builder()
        .character('&')
        .hexColors()
        .build()

    @EventHandler(priority = EventPriority.LOWEST)
    fun onChat(event : AsyncChatEvent) {
        val player : Player = event.player
        if(player.hasPermission("chatcolors.colored")) {

            val message : Component = event.message()
            val legacyMessage : String = componentSerializer.serialize(message)
            val strippedMessage : String = colorsPattern.matcher(legacyMessage).replaceAll("")

            if(strippedMessage.trim().isBlank()) return

            val coloredMessage : Component = componentSerializer.deserialize(legacyMessage)
            event.message(coloredMessage)

        }
    }

}