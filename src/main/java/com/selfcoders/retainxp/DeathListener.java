package com.selfcoders.retainxp;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener implements Listener {
    private final RetainXP plugin;

    DeathListener(RetainXP plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();

        if (!player.hasPermission("retainxp.retain")) {
            return;
        }

        int oldLevel = player.getLevel();

        double multiplier = plugin.getConfig().getDouble("multiplier", 1.0);

        int newLevel = (int) (oldLevel * multiplier);

        event.setNewLevel(newLevel);
        event.setDroppedExp(0);
    }
}
