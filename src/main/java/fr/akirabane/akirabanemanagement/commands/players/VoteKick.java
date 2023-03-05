package fr.akirabane.akirabanemanagement.commands.players;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VoteKick implements CommandExecutor {
    public int Vote = 0;
    public int VoteMax = 0;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {

            Player p = (Player)sender;
            Player target = Bukkit.getPlayer(args[0]);
            int TotalPlayer = Bukkit.getOnlinePlayers().size();
            VoteMax = (TotalPlayer / 2) + 1;

                if(target == null) {
                    p.sendMessage("Le joueur n'est pas connecté.");
                    return false;
                } else {
                    if (command.getName().equalsIgnoreCase("Votekick")) {
                        if (Vote == 0) {
                            Vote = Vote + 1;
                            p.sendMessage("Vous avez voté pour kick " + target.getName() + ".");
                            target.sendMessage(p.getName() + " a voté pour vous kick.");
                            if (Vote == VoteMax) {
                                target.kickPlayer("Vous avez été kick par la majorité des joueurs.");
                                Vote = 0;
                            }
                        } else {
                            p.sendMessage("Vous avez déjà voté.");
                        }
                    }
                }
            }
        return false;
    }
}
