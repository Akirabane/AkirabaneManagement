package fr.akirabane.akirabanemanagement;

import fr.akirabane.akirabanemanagement.commands.players.Ping;
import fr.akirabane.akirabanemanagement.commands.players.VoteKick;
import fr.akirabane.akirabanemanagement.commands.staff.Freeze;
import fr.akirabane.akirabanemanagement.commands.staff.Staff;
import fr.akirabane.akirabanemanagement.listeners.players.OnPlayerFirstTime;
import fr.akirabane.akirabanemanagement.listeners.players.OnPlayerJoin;
import fr.akirabane.akirabanemanagement.listeners.players.OnPlayerQuit;
import fr.akirabane.akirabanemanagement.listeners.staff.StaffMode;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Hello world !");

        saveDefaultConfig();

        //COMMANDS
        //player commands
        getCommand("ping").setExecutor(new Ping());
        getCommand("Votekick").setExecutor(new VoteKick());

        //command staff
        getCommand("staff").setExecutor(new Staff());
        getCommand("freeze").setExecutor(new Freeze());

        //LISTENERS
        //player listeners
        getServer().getPluginManager().registerEvents(new OnPlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new OnPlayerQuit(), this);
        getServer().getPluginManager().registerEvents(new OnPlayerFirstTime(), this);

        //staff listeners
        getServer().getPluginManager().registerEvents(new StaffMode(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Good bye world !");
    }
}
