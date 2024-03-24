package me.thomasrba;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("&9&lPluginStaff &aActivation...");
    }

    @Override
    public void onDisable() {
        getLogger().info("&9&lPluginStaff &cDesactivation...");
    }
}