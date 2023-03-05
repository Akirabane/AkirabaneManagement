package fr.akirabane.akirabanemanagement;

import fr.akirabane.akirabanemanagement.commands.players.Ping;
import fr.akirabane.akirabanemanagement.commands.players.VoteKick;
import fr.akirabane.akirabanemanagement.commands.staff.Staff;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Hello world !");

        saveDefaultConfig();

        //player commands
        getCommand("ping").setExecutor(new Ping());
        getCommand("Votekick").setExecutor(new VoteKick());

        //command staff
        getCommand("staff").setExecutor(new Staff());


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Good bye world !");
    }
}
