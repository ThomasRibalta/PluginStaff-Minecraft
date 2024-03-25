package me.thomasrba;

import me.thomasrba.commandStaff.Gmc;
import me.thomasrba.commandStaff.Gms;
import me.thomasrba.commandStaff.Kick;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("PluginStaff Activation...");
        Objects.requireNonNull(getCommand("gmc")).setExecutor(new Gmc());
        Objects.requireNonNull(getCommand("gms")).setExecutor(new Gms());
        //Objects.requireNonNull(getCommand("ban")).setExecutor(new CommandStaff());
        //Objects.requireNonNull(getCommand("unban")).setExecutor(new CommandStaff());
        Objects.requireNonNull(getCommand("kick")).setExecutor(new Kick());
    }

    @Override
    public void onDisable() {
        getLogger().info("PluginStaff Desactivation...");
    }
}