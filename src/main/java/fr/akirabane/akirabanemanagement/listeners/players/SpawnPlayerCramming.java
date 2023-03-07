package fr.akirabane.akirabanemanagement.listeners.players;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class SpawnPlayerCramming implements Listener {
    @EventHandler
    public void maxPlayersAtSpawn(PlayerMoveEvent e) {

        //coordinates max
        int maxX1 = 1000;
        int maxZ1 = 1000;
        int maxX2 = 1010;
        int maxZ2 = 1010;

        Player p = e.getPlayer();

        //return all players in the area in an array of players
        int players = 0;
        for(Player player : p.getServer().getOnlinePlayers()) {
            if(player.getLocation().getX() >= maxX1 && player.getLocation().getX() <= maxX2 && player.getLocation().getZ() >= maxZ1 && player.getLocation().getZ() <= maxZ2) {
                players++;
                if(players >= 10) {
                    p.sendMessage("§cIl y a trop de joueurs dans la zone, veuillez patienter.");
                    e.setCancelled(true);
                }
            }
        }

    }

}
