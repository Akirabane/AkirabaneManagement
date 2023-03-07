package fr.akirabane.akirabanemanagement.listeners.players;

import fr.akirabane.akirabanemanagement.compute.ItemBuilder;
import fr.akirabane.akirabanemanagement.db.kits.KitManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class KitShopMenu implements Listener {

    private String invName = "Boutique > Kits";
    private Inventory inventory = Bukkit.createInventory(null, 9, invName);

    public KitShopMenu() {
        // TODO Auto-generated constructor stub
    }

    public void open(Player player) {
        player.openInventory(inventory);
        inventory.setItem(1, new ItemBuilder()
                .type(Material.BLAZE_POWDER)
                .name("Kit ranger")
                .lore((KitManager.RANGER.getPlayerKit(player.getUniqueId()) == 1 ? "Vous possez déjà ce kit." : "Acheter ce kit."))
                .build()
        );
        inventory.setItem(3, new ItemBuilder()
                .type(Material.IRON_SWORD)
                .name("Kit Gladiateur")
                .lore((KitManager.GLADIATEUR.getPlayerKit(player.getUniqueId()) == 1 ? "Vous possez déjà ce kit." : "Acheter ce kit."))
                .build()
        );
    }

    @EventHandler
    public void onClickInventory(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();

        if(e.getCurrentItem() == null && e.getAction() != null) return;

        if(player.getOpenInventory().getTitle().equals(invName)) {
            e.setCancelled(true);

            switch (e.getCurrentItem().getType()) {
                case BLAZE_POWDER:
                    if(KitManager.RANGER.getPlayerKit(player.getUniqueId()) < 1) {
                        KitManager.RANGER.addKit(player.getUniqueId());
                        player.sendMessage("Vous venez d'acheter le kit ranger.");
                    } else {
                        player.sendMessage("Vous possédez déjà ce kit.");
                    }
                    break;

                case IRON_SWORD:
                    if(KitManager.GLADIATEUR.getPlayerKit(player.getUniqueId()) < 1) {
                        KitManager.GLADIATEUR.addKit(player.getUniqueId());
                        player.sendMessage("Vous venez d'acheter le kit gladiateur.");
                    } else {
                        player.sendMessage("Vous possédez déjà ce kit.");
                    }
                    break;

                default:
                    break;
            }
        }
    }
}
