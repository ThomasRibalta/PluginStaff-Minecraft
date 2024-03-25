package me.thomasrba.commandStaff;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public class CommandStaff implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] strings) {
        if (sender instanceof Player) {
            if (s.equalsIgnoreCase("gmc")) {
                if (strings.length == 0) {
                    Player player = (Player) sender;
                    player.setGameMode(GameMode.CREATIVE);
                    player.sendMessage("§9§lPluginStaff §9vous passez en gamemode §aCreative§9.");
                } else if (strings.length == 1) {
                    Player player = (Player) Bukkit.getPlayer(strings[0]);
                    if (player != null) {
                        player.setGameMode(GameMode.CREATIVE);
                        player.sendMessage("§9§lPluginStaff §9vous passez en gamemode §aCreative§9.");
                    } else {
                        sender.sendMessage("§9§lPluginStaff §cLe joueur est introuvable.");
                    }
                } else {
                    sender.sendMessage("§9§lPluginStaff §cNombre d'argument invalide.");
                }
            } else if (s.equalsIgnoreCase("gms")) {
                if (strings.length == 0) {
                    Player player = (Player) sender;
                    player.setGameMode(GameMode.SURVIVAL);
                    player.sendMessage("§9§lPluginStaff §9vous passez en gamemode §7Survival§9.");
                } else if (strings.length == 1) {
                    Player player = (Player) Bukkit.getPlayer(strings[0]);
                    if (player != null) {
                        player.setGameMode(GameMode.SURVIVAL);
                        player.sendMessage("§9§lPluginStaff §9vous passez en gamemode §7Survival§9.");
                    } else {
                        sender.sendMessage("§9§lPluginStaff §cLe joueur est introuvable.");
                    }
                } else {
                    sender.sendMessage("§9§lPluginStaff §cNombre d'argument invalide.");
                }
            } else if (s.equalsIgnoreCase("ban")) {
            if (strings.length == 1) {
                Player player = (Player) Bukkit.getPlayer(strings[0]);
                if (player != null) {
                    //player.ban("","","", true);
                    sender.sendMessage("§9§lPluginStaff §9Vous avez banni un joueur.");
                } else {
                    sender.sendMessage("§9§lPluginStaff §cLe joueur est introuvable.");
                }
            } else {
                sender.sendMessage("§9§lPluginStaff §cNombre d'argument invalide.");
                }
            } else if (s.equalsIgnoreCase("kick")) {
                if (strings.length >= 1) {
                    Player player = (Player) Bukkit.getPlayer(strings[0]);
                    if (player != null) {
                        sender.sendMessage("§9§lPluginStaff §9Vous avez kick un joueur.");
                        if (strings.length >= 2) {
                            player.kickPlayer(String.format("%s%s", "§9§lPluginStaff\n\n§3Vous avez été expulsé du serveur.\n\n§9§lRaison:\n§c", String.join(" ", Arrays.copyOfRange(strings, 1, strings.length))));
                        } else {
                            player.kickPlayer("§9§lPluginStaff\n\n§3Vous avez éte expulsé du serveur.\n\n§9§lRaison:\n§cPas de raison donné.");
                        }
                    } else {
                        sender.sendMessage("§9§lPluginStaff §cLe joueur est introuvable.");
                    }
                } else {
                    sender.sendMessage("§9§lPluginStaff §cNombre d'argument invalide.");
                }
            }
        } else {
            sender.sendMessage("Vous n'etes pas un joueur !");
        }
        return false;
    }
}
