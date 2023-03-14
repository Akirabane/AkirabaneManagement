package fr.akirabane.akirabanemanagement.listeners.players;

import fr.akirabane.akirabanemanagement.db.players.PlayerManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.mindrot.jbcrypt.BCrypt;

public class OnPlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        String pseudo_player = e.getPlayer().getName();
        String uuid_player = e.getPlayer().getUniqueId().toString();
        String password_player = "password";
        String hashed = BCrypt.hashpw(password_player, BCrypt.gensalt());
        boolean is_staff = false;
        PlayerManager pm = new PlayerManager(pseudo_player, uuid_player, hashed, is_staff);
        if(!pm.playerExist(e.getPlayer().getUniqueId().toString())) {
            pm.createPlayer(e.getPlayer().getName(), e.getPlayer().getUniqueId().toString(), hashed, false);
        }
        if(!e.getPlayer().hasPlayedBefore()) {
            e.setJoinMessage("§a" + e.getPlayer().getName() + "§7 a rejoint le serveur pour la première fois.");
        } else {
            e.setJoinMessage("§a" + e.getPlayer().getName() + "§7 a rejoint le serveur.");
        }
    }
}

