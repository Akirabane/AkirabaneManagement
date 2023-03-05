package fr.akirabane.akirabanemanagement.commands.players;

import fr.akirabane.akirabanemanagement.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Camel;
import org.bukkit.entity.Player;

import java.lang.reflect.InvocationTargetException;

public class Ping implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Player p = (Player) sender;

            if(command.getName().equalsIgnoreCase("Ping")) {

                if (args.length > 0) {
                    return false;
                } else {

                    int ping = p.getPing();

                    if (ping < 20) {
                        p.sendMessage("Pong : " + p.getPing() + "ms, votre ping est excellent.");
                    } else if (ping > 20 && ping < 80) {
                        p.sendMessage("Pong : " + p.getPing() + "ms, votre ping est correct.");
                    } else if (ping > 80 && ping < 150) {
                        p.sendMessage("Pong : " + p.getPing() + "ms, votre ping est moyen.");
                    } else {
                        p.sendMessage("Pong : " + p.getPing() + "ms, votre ping est anormalement élevé.");
                    }
                }
            }
        }

        return false;
    }
}
