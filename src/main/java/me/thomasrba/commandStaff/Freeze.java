package me.thomasrba.commandStaff;

import me.thomasrba.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Freeze implements CommandExecutor {

    Main main;
    public Freeze(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (!sender.hasPermission("PluginStaff.freeze")){
            sender.sendMessage("§9§lPluginStaff §cVous n'avez pas la permission de faire cela.");
            return false;
        }
        if (strings.length < 1){
            sender.sendMessage("§9§lPluginStaff §c/freeze 'PSUEDO'.");
            return false;
        }
        Player player = Bukkit.getPlayer(strings[0]);
        if (player == null){
            sender.sendMessage("§9§lPluginStaff §cle joueur ciblé est introuvable.");
            return false;
        }
        if (main.playerStates.get(player.getUniqueId()).freeze) {
            sender.sendMessage("§9§lPluginStaff §9Vous avez sorti §6"+ player.getName() +"§9 du §4Freeze§9.");
            player.sendMessage("§9§lPluginStaff §9Vous etes plus §4Freeze§9.");
            main.playerStates.get(player.getUniqueId()).freeze = false;
        }
        else {
            sender.sendMessage("§9§lPluginStaff §9Vous avez mis §6"+ player.getName() +"§9 en §aFreeze§9.");
            player.sendMessage("§9§lPluginStaff §9Vous etes §aFreeze§9.");
            main.playerStates.get(player.getUniqueId()).freeze = true;
        }
        return false;
    }
}
