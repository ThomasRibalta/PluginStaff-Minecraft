package me.thomasrba.commandStaff;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Kill implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (!sender.hasPermission("PluginStaff.kill")){
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
        sender.sendMessage("§9§lPluginStaff §aVous avez éliminer le joueur §6"+ player.getName() +".");
        player.sendMessage("§9§lPluginStaff §cVous venez de vous faire éliminer.");
        player.damage(20);
        return false;
    }
}
