package net.warvale.core.connect;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import net.md_5.bungee.api.ChatColor;
import net.warvale.core.Main;

public class LeaveServer implements Listener {

    public LeaveServer(Main plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler

    public void onPlayerLeaveEvent(PlayerQuitEvent event) {

        String playerName = event.getPlayer().getName();
        event.getPlayer().getInventory().clear();

        if (Main.getSpectatorTeam().getEntries().contains(event.getPlayer().getName())) {
            Main.getSpectatorTeam().removeEntry(event.getPlayer().getName());
        }

        if (Main.getRedTeam().getEntries().contains(event.getPlayer().getName())) {
            Main.getRedTeam().removeEntry(event.getPlayer().getName());
        }

        if (Main.getBlueTeam().getEntries().contains(event.getPlayer().getName())) {
            Main.getBlueTeam().removeEntry(event.getPlayer().getName());
        }

        event.setQuitMessage(ChatColor.GRAY + playerName + ChatColor.GRAY + " left.");

    }
}
