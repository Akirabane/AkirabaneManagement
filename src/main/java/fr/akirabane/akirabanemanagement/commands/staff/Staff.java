package fr.akirabane.akirabanemanagement.commands.staff;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class Staff implements CommandExecutor {
    //check if player is in staff mode or not
    public boolean isStaffMode = false;
    Map<UUID, ItemStack[]> items = new HashMap<UUID, ItemStack[]>();
    Map<UUID, ItemStack[]> armor = new HashMap<UUID, ItemStack[]>();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

        if(command.getName().equalsIgnoreCase("staff")) {
            if(!p.hasPermission("akirabane.staff")) {
                p.sendMessage("§cVous n'avez pas la permission d'utiliser cette commande !");
                return false;
            }

            if(args.length > 0) {
                p.sendMessage("§cVous ne pouvez effectuer la commande que sur vous-même !");
                return false;
            }

            if(!isStaffMode) {
                p.sendMessage("vous êtes en mode staff");
                storeAndClearInventory(p);
                ItemStack staffItem = new ItemStack(Material.CLOCK, 1);
                ItemMeta staffItemMeta = staffItem.getItemMeta();
                staffItemMeta.setDisplayName("§cMode Staff");
                staffItem.setItemMeta(staffItemMeta);
                p.getInventory().setItem(4, staffItem);
                isStaffMode = true;
            } else {
                p.sendMessage("vous n'êtes plus en mode staff");
                restoreInventory(p);
                isStaffMode = false;
            }


        }

        return false;
    }

    public void storeAndClearInventory(Player player){
        UUID uuid = player.getUniqueId();

        ItemStack[] contents = player.getInventory().getContents();
        ItemStack[] armorContents = player.getInventory().getArmorContents();

        items.put(uuid, contents);
        armor.put(uuid, armorContents);

        player.getInventory().clear();

        player.getInventory().setHelmet(null);
        player.getInventory().setChestplate(null);
        player.getInventory().setLeggings(null);
        player.getInventory().setBoots(null);
    }

    public void restoreInventory(Player player) {
        UUID uuid = player.getUniqueId();

        ItemStack[] contents = items.get(uuid);
        ItemStack[] armorContents = armor.get(uuid);

        if (contents != null) {
            player.getInventory().setContents(contents);
        } else {//if the player has no inventory contents, clear their inventory
            player.getInventory().clear();
        }

        if (armorContents != null) {
            player.getInventory().setArmorContents(armorContents);
        } else {//if the player has no armor, set the armor to null
            player.getInventory().setHelmet(null);
            player.getInventory().setChestplate(null);
            player.getInventory().setLeggings(null);
            player.getInventory().setBoots(null);
        }
    }

}
