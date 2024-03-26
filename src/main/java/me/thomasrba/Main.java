package me.thomasrba;

import me.thomasrba.commandStaff.*;
import me.thomasrba.listeners.JoinEvent;
import me.thomasrba.listeners.LeaveEvent;
import me.thomasrba.listeners.WalkEvent;
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
        Objects.requireNonNull(getCommand("kick")).setExecutor(new Kick());
        Objects.requireNonNull(getCommand("fly")).setExecutor(new Fly());
        Objects.requireNonNull(getCommand("kill")).setExecutor(new Kill());
        Objects.requireNonNull(getCommand("vanish")).setExecutor(new Vanish(this));
        Objects.requireNonNull(getCommand("freeze")).setExecutor(new Freeze(this));
        Objects.requireNonNull(getCommand("invsee")).setExecutor(new Invsee());
        Bukkit.getServer().getPluginManager().registerEvents(new JoinEvent(this), this);
        Bukkit.getServer().getPluginManager().registerEvents(new WalkEvent(this), this);
        Bukkit.getServer().getPluginManager().registerEvents(new LeaveEvent(this), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("PluginStaff Desactivation...");
    }
}