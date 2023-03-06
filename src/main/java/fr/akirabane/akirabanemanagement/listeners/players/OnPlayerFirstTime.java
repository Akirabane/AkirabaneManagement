package fr.akirabane.akirabanemanagement.listeners.players;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnPlayerFirstTime implements Listener {
    @EventHandler
    public void onPlayerFirstTimeEvent(PlayerJoinEvent e) {
        if(!e.getPlayer().hasPlayedBefore()) {
            e.getPlayer().sendMessage("§aBienvenue sur le serveur !");
        }
    }
}
