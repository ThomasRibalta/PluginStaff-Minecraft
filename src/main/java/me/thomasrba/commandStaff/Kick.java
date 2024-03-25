package me.thomasrba.commandStaff;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class Kick implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] strings) {
        if (!sender.hasPermission("PluginStaff.kick")){
            sender.sendMessage("§9§lPluginStaff §cVous n'avez pas la permission de faire cela.");
            return false;
        }
        if (strings.length < 1){
            sender.sendMessage("§9§lPluginStaff §c/kick 'joueur' ['raison'].");
            return false;
        }
        Player player = (Player) Bukkit.getPlayer(strings[0]);
        if (player == null){
            sender.sendMessage("§9§lPluginStaff §cle joueur ciblé est introuvable.");
            return false;
        }
        if (strings.length == 1)
        {
            player.kickPlayer("§9§lPluginStaff\n\n§3Vous avez éte expulsé du serveur.\n\n§9§lRaison:\n§cPas de raison donné.");
            sender.sendMessage("§9§lPluginStaff §ale joueur §6"+ player.getName() +"§a a bien été expulsé !");
            return true;
        }
        player.kickPlayer(String.format("%s%s", "§9§lPluginStaff\n\n§3Vous avez été expulsé du serveur.\n\n§9§lRaison:\n§c", String.join(" ", Arrays.copyOfRange(strings, 1, strings.length))));
        sender.sendMessage("§9§lPluginStaff §ale joueur §6"+ player.getName() +"§a a bien été expulsé !");
        return true;
    }
}
