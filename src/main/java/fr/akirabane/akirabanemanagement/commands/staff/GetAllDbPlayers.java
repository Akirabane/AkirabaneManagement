package fr.akirabane.akirabanemanagement.commands.staff;

import fr.akirabane.akirabanemanagement.db.players.PlayerManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class GetAllDbPlayers implements CommandExecutor {

    PlayerManager pm = new PlayerManager();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        Player player = (Player) sender;

            if (!(sender instanceof Player)) {
                sender.sendMessage("§cVous devez être un joueur pour exécuter cette commande.");
                return true;
            }

            if(pm.getAllPlayers().isEmpty()) {
                player.sendMessage("§cAucun joueur n'a été trouvé dans la base de données.");
                return true;
            } else {
                player.sendMessage("§aVoici la liste des joueurs présents dans la base de données: " + pm.getAllPlayers());
            }

        return false;
    }
}
