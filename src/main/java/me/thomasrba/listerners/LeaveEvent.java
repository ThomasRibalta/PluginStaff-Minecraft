package me.thomasrba.listerners;

import me.thomasrba.Main;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveEvent implements Listener {

    Main main;
    public LeaveEvent(Main main) {
        this.main = main;
    }

    @EventHandler
    public void PlayerQuit(PlayerQuitEvent e)
    {
        Bukkit.getServer().broadcastMessage("- 1 (" + e.getPlayer().getUniqueId() + ")");
        main.playerStates.remove(e.getPlayer().getUniqueId());
    }
}
