package me.thomasrba.listeners;

import me.thomasrba.Main;
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
        //main.playerStates.remove(e.getPlayer().getUniqueId());
    }
}
