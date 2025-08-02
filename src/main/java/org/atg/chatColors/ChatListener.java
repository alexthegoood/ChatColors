package org.atg.chatColors;

import io.papermc.paper.event.player.AsyncChatEvent;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import java.util.regex.Pattern;

public class ChatListener implements Listener {

    private static final Pattern COLORS_PATTERN = Pattern.compile("[&§][0-9a-fk-or]");

    private static final LegacyComponentSerializer COMPONENT_SERIALIZER = LegacyComponentSerializer.builder()
            .character('&')
            .hexColors()
            .build();

    @EventHandler(priority = EventPriority.LOWEST)
    public void onChat(AsyncChatEvent event) {
        Player player = event.getPlayer();
        if(player.hasPermission("chatcolor.colored")) {

            Component message = event.message();
            String legacyMessage = COMPONENT_SERIALIZER.serialize(message);
            String strippedMessage = COLORS_PATTERN.matcher(legacyMessage).replaceAll("");

            if(strippedMessage.trim().isBlank()) return;

            Component coloredMessage = COMPONENT_SERIALIZER.deserialize(legacyMessage);
            event.message(coloredMessage);

        }
    }
}
