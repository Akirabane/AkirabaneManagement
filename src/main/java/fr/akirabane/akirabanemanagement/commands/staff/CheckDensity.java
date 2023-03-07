package fr.akirabane.akirabanemanagement.commands.staff;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class CheckDensity implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        Player p = (Player) sender;

        if(!(sender instanceof Player)) {
            sender.sendMessage("§cYou must be a player to execute this command.");
            return false;
        }

        if(command.getName().equalsIgnoreCase("checkdensity")) {

            if(!p.hasPermission("akirabane.staff")) {
                p.sendMessage("§cVous n'avez pas la permission d'utiliser cette commande !");
                return false;
            }


        }

        if(args.length == 0 || args.length < 4 || args.length > 4) {
            p.sendMessage("§cUsage: /checkdensity <X1> <Z1> <X2> <Z2>");
            return false;
        }

        //coordinates max
        int maxX1 = Integer.parseInt(args[0]);
        int maxZ1 = Integer.parseInt(args[1]);
        int maxX2 = Integer.parseInt(args[2]);
        int maxZ2 = Integer.parseInt(args[3]);

        //return how many players are in the area
        int players = 0;
        for(Player player : p.getServer().getOnlinePlayers()) {
            if(player.getLocation().getX() >= maxX1 && player.getLocation().getX() <= maxX2 && player.getLocation().getZ() >= maxZ1 && player.getLocation().getZ() <= maxZ2) {
                players++;
                p.sendMessage("§aIl y a " + players + " joueur(s) dans la zone.");
            }
        }

        return false;
    }
}
