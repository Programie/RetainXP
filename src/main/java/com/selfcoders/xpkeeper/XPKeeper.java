package com.selfcoders.xpkeeper;

import org.bukkit.plugin.java.JavaPlugin;

public class XPKeeper extends JavaPlugin {
    public void onEnable() {
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new DeathListener(this), this);
    }
}
