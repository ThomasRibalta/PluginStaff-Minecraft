package me.thomasrba.commandStaff;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (!sender.hasPermission("PluginStaff.fly")){
            sender.sendMessage("§9§lPluginStaff §cVous n'avez pas la permission de faire cela.");
            return false;
        }
        if (!(strings.length == 0 || strings.length == 1)){
            sender.sendMessage("§9§lPluginStaff §c/fly 'PSUEDO'.");
            return false;
        }
        if (strings.length == 0) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("§9§lPluginStaff §cSeul les joueurs peuvent voler.");
                return false;
            }
            if (((Player) sender).isFlying()){
                ((Player) sender).setFlying(false);
                sender.sendMessage("§9§lPluginStaff §9Vous arretez de §4Fly §9.");
                return true;
            }
            ((Player) sender).setFlying(true);
            sender.sendMessage("§9§lPluginStaff §9Vous commencez a §aFly §9.");
            return  true;
        }
        Player player = Bukkit.getPlayer(strings[0]);
        if (player == null){
            sender.sendMessage("§9§lPluginStaff §cle joueur ciblé est introuvable.");
            return false;
        }
        if (player.isFlying()){
            player.setFlying(false);
            player.sendMessage("§9§lPluginStaff §9Vous arretez de §4Fly §9.");
            sender.sendMessage("§9§lPluginStaff §9vous avez enlevé le §4fly §9a §6"+ player.getName() +"§9.");
            return true;
        }
        player.setFlying(true);
        sender.sendMessage("§9§lPluginStaff §9vous avez donné le §afly §9a §6"+ player.getName() +"§9.");
        player.sendMessage("§9§lPluginStaff §9Vous commencez a §aFly §9.");
        return true;
    }
}
