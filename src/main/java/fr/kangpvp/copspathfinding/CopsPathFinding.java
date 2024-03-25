package fr.kangpvp.copspathfinding;

import fr.kangpvp.copspathfinding.commands.SpawnCopCmd;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class CopsPathFinding extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginCommand("spawncop").setExecutor(new SpawnCopCmd());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
