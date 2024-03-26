package me.thomasrba.commandStaff;

import me.thomasrba.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;
import java.util.UUID;

public class Vanish implements CommandExecutor {

    Main main;

    public Vanish(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] strings) {
        if (!sender.hasPermission("PluginStaff.vanish")){
            sender.sendMessage("§9§lPluginStaff §cVous n'avez pas la permission de faire cela.");
            return false;
        }
        if (!((strings.length == 1) || (strings.length == 0))){
            sender.sendMessage("§9§lPluginStaff §c/vanish 'PSUEDO'.");
            return false;
        }
        if (strings.length == 0) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("§9§lPluginStaff §cSeul les joueurs peuvent devenir invisible.");
                return false;
            }
            if (main.playerStates.get(((Player) sender).getUniqueId()).vanish) {
                sender.sendMessage("§9§lPluginStaff §9Vous sortez du §4Vanish§9.");
                for (Player p : Bukkit.getOnlinePlayers()){
                    p.showPlayer(main, (Player) sender);
                }
                main.playerStates.get(((Player) sender).getUniqueId()).vanish = false;
            }
            else {
                sender.sendMessage("§9§lPluginStaff §9Vous passez en §aVanish§9.");
                for (Player p : Bukkit.getOnlinePlayers()){
                    p.hidePlayer(main, (Player) sender);
                }
                main.playerStates.get(((Player) sender).getUniqueId()).vanish = true;
            }
            return true;
        }
        Player player = Bukkit.getPlayer(strings[0]);
        if (player == null){
            sender.sendMessage("§9§lPluginStaff §cle joueur ciblé est introuvable.");
            return false;
        }
        if (main.playerStates.get(player.getUniqueId()).vanish) {
            sender.sendMessage("§9§lPluginStaff §9Vous avez sorti §6"+ player.getName() +"§9 du §4Vanish§9.");
            player.sendMessage("§9§lPluginStaff §9Vous sortez du §4Vanish§9.");
            for (Player p : Bukkit.getOnlinePlayers()){
                p.showPlayer(main, player);
            }
            main.playerStates.get(player.getUniqueId()).vanish = false;
        }
        else {
            sender.sendMessage("§9§lPluginStaff §9Vous avez mis §6"+ player.getName() +"§9 en §aVanish§9.");
            player.sendMessage("§9§lPluginStaff §9Vous passez en §aVanish§9.");
            for (Player p : Bukkit.getOnlinePlayers()){
                p.hidePlayer(main, player);
            }
            main.playerStates.get(player.getUniqueId()).vanish = true;
        }
        return true;
    }
}
