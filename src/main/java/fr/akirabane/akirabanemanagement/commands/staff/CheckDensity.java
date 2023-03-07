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
        int maxY1 = 320;
        int maxZ1 = Integer.parseInt(args[1]);
        int maxX2 = Integer.parseInt(args[2]);
        int maxY2 = 320;
        int maxZ2 = Integer.parseInt(args[3]);

        int maxX3 = maxX1;
        int maxY3 = 320;
        int maxZ3 = maxZ2;

        int maxX4 = maxX2;
        int maxY4 = 320;
        int maxZ4 = maxZ1;

        //coordinates min
        int minX1 = Integer.parseInt(args[0]);
        int minY1 = -64;
        int minZ1 = Integer.parseInt(args[1]);
        int minX2 = Integer.parseInt(args[2]);
        int minY2 = -64;
        int minZ2 = Integer.parseInt(args[3]);

        int minx3 = minX1;
        int miny3 = -64;
        int minz3 = minZ2;

        int minx4 = minX2;
        int miny4 = -64;
        int minz4 = minZ1;

        //print in console the coordinates max and min
        p.sendMessage("§aCoordinates max: " + maxX1 + " " + maxY1 + " " + maxZ1 + " " + maxX2 + " " + maxY2 + " " + maxZ2 + " " + maxX3 + " " + maxY3 + " " + maxZ3 + " " + maxX4 + " " + maxY4 + " " + maxZ4);
        p.sendMessage("§aCoordinates min: " + minX1 + " " + minY1 + " " + minZ1 + " " + minX2 + " " + minY2 + " " + minZ2 + " " + minx3 + " " + miny3 + " " + minz3 + " " + minx4 + " " + miny4 + " " + minz4);

        return false;
    }
}
