package fr.akirabane.akirabanemanagement.commands.players;

import fr.akirabane.akirabanemanagement.compute.gui.KitShopMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KitCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        // TODO Auto-generated method stub
        if(!(sender instanceof Player)) {
            return true;
        }

        Player player = (Player)sender;

        if(args.length == 0) {
            new KitShopMenu().open(player);
            return true;
        }
        return true;
    }
}
