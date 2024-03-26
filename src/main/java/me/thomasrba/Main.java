package me.thomasrba;

import me.thomasrba.commandStaff.Gmc;
import me.thomasrba.commandStaff.Gms;
import me.thomasrba.commandStaff.Kick;
import me.thomasrba.commandStaff.Vanish;
import me.thomasrba.listerners.JoinEvent;
import me.thomasrba.listerners.LeaveEvent;
import me.thomasrba.utils.Playerstate;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class Main extends JavaPlugin {

    public Map<UUID, Playerstate> playerStates = new HashMap<UUID, Playerstate>();
    @Override
    public void onEnable() {
        getLogger().info("PluginStaff Activation...");
        Objects.requireNonNull(getCommand("gmc")).setExecutor(new Gmc());
        Objects.requireNonNull(getCommand("gms")).setExecutor(new Gms());
        //Objects.requireNonNull(getCommand("ban")).setExecutor(new CommandStaff());
        //Objects.requireNonNull(getCommand("unban")).setExecutor(new CommandStaff());
        Objects.requireNonNull(getCommand("kick")).setExecutor(new Kick());
        Objects.requireNonNull(getCommand("vanish")).setExecutor(new Vanish(this));
        Bukkit.getServer().getPluginManager().registerEvents(new JoinEvent(this), this);
        Bukkit.getServer().getPluginManager().registerEvents(new LeaveEvent(this), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("PluginStaff Desactivation...");
    }
}