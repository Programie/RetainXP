package com.selfcoders.xpkeeper;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener implements Listener {
    private final XPKeeper plugin;

    DeathListener(XPKeeper plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();

        if (!player.hasPermission("xpkeeper.keep")) {
            return;
        }

        int oldLevel = player.getLevel();

        double multiplier = plugin.getConfig().getDouble("multiplier", 1.0);

        int newLevel = (int) (oldLevel * multiplier);

        event.setNewLevel(newLevel);
        event.setDroppedExp(0);
    }
}
