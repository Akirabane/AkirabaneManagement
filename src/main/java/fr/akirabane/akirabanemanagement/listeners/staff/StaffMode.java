package fr.akirabane.akirabanemanagement.listeners.staff;

import fr.akirabane.akirabanemanagement.commands.staff.Staff;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class StaffMode implements Listener {
    @EventHandler
    public void onStaffMode(PlayerInteractEvent e) {

        if(Staff.getStaffMode() == false) {
            return;
        }

        if(e.getAction().name().contains("LEFT")) {
            e.setCancelled(true);
            return;
        }

        //check item name and create siwtch case depending on the item name
        String itemName = e.getItem().getItemMeta().getDisplayName();
        switch (itemName) {
            case "§cMode Staff":
                break;
            case "§cQuitter le mode staff":
                e.getPlayer().performCommand("staff");
                break;
            default:
                break;
        }
    }
}
