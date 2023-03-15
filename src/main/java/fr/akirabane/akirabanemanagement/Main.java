package fr.akirabane.akirabanemanagement;

import fr.akirabane.akirabanemanagement.commands.players.KitCommand;
import fr.akirabane.akirabanemanagement.commands.players.Ping;
import fr.akirabane.akirabanemanagement.commands.players.ShopCommand;
import fr.akirabane.akirabanemanagement.commands.players.VoteKick;
import fr.akirabane.akirabanemanagement.commands.staff.CheckDensity;
import fr.akirabane.akirabanemanagement.commands.staff.Freeze;
import fr.akirabane.akirabanemanagement.commands.staff.GetAllDbPlayers;
import fr.akirabane.akirabanemanagement.commands.staff.Staff;
import fr.akirabane.akirabanemanagement.compute.gui.KitShopMenu;
import fr.akirabane.akirabanemanagement.db.DatabaseManager;
import fr.akirabane.akirabanemanagement.listeners.players.*;
import fr.akirabane.akirabanemanagement.listeners.staff.StaffMode;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public DatabaseManager db;

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Hello world !");

        saveDefaultConfig();

        //database connexion
        db = new DatabaseManager("jdbc:mysql://", "193.168.146.197:3306", "akirabane_api", "akirabane", "55278");
        db.connexion();

        //COMMANDS
        //player commands
        getCommand("ping").setExecutor(new Ping());
        getCommand("Votekick").setExecutor(new VoteKick());
        getCommand("boutique").setExecutor(new ShopCommand());
        getCommand("kit").setExecutor(new KitCommand());

        //command staff
        getCommand("staff").setExecutor(new Staff());
        getCommand("freeze").setExecutor(new Freeze());
        getCommand("checkdensity").setExecutor(new CheckDensity());
        getCommand("getalldbplayers").setExecutor(new GetAllDbPlayers());

        //LISTENERS
        //player listeners
        getServer().getPluginManager().registerEvents(new OnPlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new OnPlayerQuit(), this);
        getServer().getPluginManager().registerEvents(new OnPlayerFirstTime(), this);
        getServer().getPluginManager().registerEvents(new KitShopMenu(), this);
        //getServer().getPluginManager().registerEvents(new SpawnPlayerCramming(), this);

        //staff listeners
        getServer().getPluginManager().registerEvents(new StaffMode(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Good bye world !");
        db.deconnexion();
    }
}
