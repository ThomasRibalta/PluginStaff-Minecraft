package me.thomasrba.listerners;

import me.thomasrba.Main;
import me.thomasrba.utils.Playerstate;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

    Main main;
    public JoinEvent(Main main){
        this.main = main;
    }

    @EventHandler
    public void PlayerJoin(PlayerJoinEvent e){
        Bukkit.getServer().broadcastMessage("+ 1 (" + e.getPlayer().getUniqueId() + ")");
        main.playerStates.put(e.getPlayer().getUniqueId(), new Playerstate());
        for (Player p: Bukkit.getServer().getOnlinePlayers()){
            if (main.playerStates.get(p.getUniqueId()).vanish){
                e.getPlayer().hidePlayer(main, p);
            }
        }
    }
}
