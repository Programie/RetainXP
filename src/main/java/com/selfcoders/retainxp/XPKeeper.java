package com.selfcoders.retainxp;

import org.bukkit.plugin.java.JavaPlugin;

public class RetainXP extends JavaPlugin {
    public void onEnable() {
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new DeathListener(this), this);
    }
}
