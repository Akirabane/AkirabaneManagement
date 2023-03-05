package fr.akirabane.akirabanemanagement.commands.players;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VoteKick implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {

            Player p = (Player)sender;
            Player target = Bukkit.getPlayer(args[1]);

            if(command.getName().equalsIgnoreCase("Votekick")) {
                switch (args.length) {
                    case 0:
                        p.sendMessage("Vous devez effectuer la commande /Votekick <Pseudo>");
                        break;
                    case 1:
                        target.kickPlayer("Test");
                        p.sendMessage("Vous avez votekick : " + target.getName());
                        break;
                    default:
                        p.sendMessage("Erreur dans la commande : /Votekick <Pseudo>");
                        break;
                }
            }

        }

        return false;
    }
}
