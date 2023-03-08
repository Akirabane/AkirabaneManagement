package fr.akirabane.akirabanemanagement.commands.staff;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.List;

public class CheckDensity implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        Player p = (Player) sender;
        World w = p.getWorld();

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
        //point A
        int maxX1 = Integer.parseInt(args[0]);
        int maxZ1 = Integer.parseInt(args[1]);

        //point B
        int maxX2 = Integer.parseInt(args[2]);
        int maxZ2 = Integer.parseInt(args[3]);

        //point C
        int maxX3 = maxX1;
        int maxZ3 = maxZ2;

        //formule : racine de (x3 - x1)² + (z3 - z1)² pour la distance entre AC
        //formule : racine de (x3 - x2)² + (z3 - z2)² pour la distance entre BC

        int distanceAC = (int) Math.sqrt(Math.pow(maxX3 - maxX1, 2) + Math.pow(maxZ3 - maxZ1, 2));
        int distanceBC = (int) Math.sqrt(Math.pow(maxX3 - maxX2, 2) + Math.pow(maxZ3 - maxZ2, 2));

        //calculer l'air du rectangle
        int aire = distanceAC * distanceBC;

        p.sendMessage("§aLa zone fait " + distanceAC + " bloc(s) de large et " + distanceBC + " bloc(s) de long, soit une aire de " + aire + " bloc(s)².");
        int players = 0;
        for(Player player : w.getPlayers()) {
            if(player.getLocation().getX() >= maxX1 && player.getLocation().getX() <= maxX2 && player.getLocation().getZ() >= maxZ1 && player.getLocation().getZ() <= maxZ2) {
                players++;
            }
        }
        float playerParMetreCarre = players / (float) aire;
        p.sendMessage("§aIl y a " + players + " joueur(s) dans la zone, cela fait " + playerParMetreCarre + " joueur(s) au mètre carré.");


        return false;
    }
}
