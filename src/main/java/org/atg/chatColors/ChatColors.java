package org.atg.chatColors;

import org.bukkit.plugin.java.JavaPlugin;

public final class ChatColors extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new ChatListener(), this);
    }

}
