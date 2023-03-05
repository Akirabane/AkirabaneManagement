package fr.akirabane.akirabanemanagement.commands.players;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VoteKick implements CommandExecutor {
    public int Vote = 0;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {

            Player p = (Player)sender;
            Player target = Bukkit.getPlayer(args[1]);

            if(command.getName().equalsIgnoreCase("Votekick")) {
                if (args.length == 0) {
                    p.sendMessage("Vous devez effectuer la commande /Votekick <Pseudo>");
                } else if (args.length == 1)
                    p.sendMessage("Vous avez votekick : " + target.getName());
                    Vote += 1;
                    if(Vote == 1) {
                        Bukkit.broadcastMessage(Vote + " personne ont voté pour kick " + target.getName());
                    } else {
                        Bukkit.broadcastMessage(Vote + " personnes ont voté pour kick " + target.getName());
                    }

                } else {
                    p.sendMessage("Erreur dans la commande : /Votekick <Pseudo>");
                }
            }
        return false;
    }
}
