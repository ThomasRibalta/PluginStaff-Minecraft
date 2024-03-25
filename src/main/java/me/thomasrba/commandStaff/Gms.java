package me.thomasrba.commandStaff;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gms implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] strings) {
        if (!sender.hasPermission("PluginStaff.gms")){
            sender.sendMessage("§9§lPluginStaff §cVous n'avez pas la permission de faire cela.");
            return false;
        }
        if (!((strings.length == 1) || (strings.length == 0))){
            sender.sendMessage("§9§lPluginStaff §c/gmc 'PSUEDO'.");
            return false;
        }
        if (strings.length == 0) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("§9§lPluginStaff §cSeul les joueurs peuvent changer de gamemode.");
                return false;
            }
            ((Player) sender).setGameMode(GameMode.SURVIVAL);
            sender.sendMessage("§9§lPluginStaff §9Vous passez en §4survie§9.");
            return true;
        }
        Player player = Bukkit.getPlayer(strings[0]);
        if (player == null){
            sender.sendMessage("§9§lPluginStaff §cle joueur ciblé est introuvable.");
            return false;
        }
        player.setGameMode(GameMode.SURVIVAL);
        player.sendMessage("§9§lPluginStaff §9Vous passez en §4survie§9.");
        sender.sendMessage("§9§lPluginStaff §9Vous avez mis§6 " + player.getName() + " §9en §4survie§9.");
        return true;
    }
}
