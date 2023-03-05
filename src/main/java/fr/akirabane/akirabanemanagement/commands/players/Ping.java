package fr.akirabane.akirabanemanagement.commands.players;

import fr.akirabane.akirabanemanagement.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Ping implements CommandExecutor {

    private Main main;

    public Ping(Main main) {
        this.main = main;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Player p = (Player) sender;

            if(command.getName().equalsIgnoreCase("Ping")) {
                if(args.length == 0) {
                    p.sendMessage("Pong :" + Bukkit.getServer().getPlayer(String.valueOf(sender)).getPing());
                } else {
                    p.sendMessage("Commande : /ping.");
                }
            }
        }

        return false;
    }
}
