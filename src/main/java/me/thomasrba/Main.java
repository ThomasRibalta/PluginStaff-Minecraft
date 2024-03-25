package me.thomasrba;

import org.bukkit.plugin.java.JavaPlugin;
import me.thomasrba.commandStaff.CommandStaff;

import java.util.Objects;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("PluginStaff Activation...");
        Objects.requireNonNull(getCommand("gmc")).setExecutor(new CommandStaff());
        Objects.requireNonNull(getCommand("gms")).setExecutor(new CommandStaff());
        Objects.requireNonNull(getCommand("ban")).setExecutor(new CommandStaff());
        Objects.requireNonNull(getCommand("kick")).setExecutor(new CommandStaff());
    }

    @Override
    public void onDisable() {
        getLogger().info("PluginStaff Desactivation...");
    }
}