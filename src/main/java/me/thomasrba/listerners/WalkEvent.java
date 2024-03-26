package me.thomasrba.listerners;

import me.thomasrba.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class WalkEvent implements Listener {

    Main main;
    public WalkEvent(Main main) {
        this.main = main;
    }

    @EventHandler
    public void PlayerWalk(PlayerMoveEvent e)
    {
        if (main.playerStates.get(e.getPlayer().getUniqueId()).freeze){
            e.getPlayer().sendMessage("§9§lPluginStaff §cVous pouvez pas bouger vous etes freeze.§9." );
            e.setCancelled(true);
        }else{
            e.setCancelled(false);
        }
    }
}
