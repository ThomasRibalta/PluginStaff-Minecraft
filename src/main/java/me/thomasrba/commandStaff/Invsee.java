package me.thomasrba.commandStaff;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Invsee implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (!sender.hasPermission("PluginStaff.invsee")){
            sender.sendMessage("§9§lPluginStaff §cVous n'avez pas la permission de faire cela.");
            return false;
        }
        if (strings.length < 1){
            sender.sendMessage("§9§lPluginStaff §c/kill 'PSUEDO'.");
            return false;
        }
        Player player = Bukkit.getPlayer(strings[0]);
        if (player == null){
            sender.sendMessage("§9§lPluginStaff §cle joueur ciblé est introuvable.");
            return false;
        }
        if (!(sender instanceof Player)){
            sender.sendMessage("§9§lPluginStaff §cVous ne pouvez pas voir un inventaire.");
            return false;
        }
        ((Player) sender).openInventory(player.getInventory());
        sender.sendMessage("§9§lPluginStaff §9Vous ouvrez l'inventaire de §6"+ player.getName() +"§9.");
        return true;
    }
}
