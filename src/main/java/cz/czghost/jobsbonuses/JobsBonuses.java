package cz.czghost.jobsbonuses;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class JobsBonuses extends JavaPlugin {

    public Plugin jobs;
    public Plugin placeholderAPI;

    @Override
    public void onEnable() {
        // Plugin startup logic: hook into dependent plugins
        getLogger().log(Level.INFO, "Hooking into Jobs and PlaceholderAPI plugins...");
        jobs = getServer().getPluginManager().getPlugin("Jobs");
        placeholderAPI = getServer().getPluginManager().getPlugin("PlaceholderAPI");

        // Check dependency => disable if dependencies were not found
        if(jobs == null || placeholderAPI == null) {
            getLogger().log(Level.SEVERE,
                    "At least one dependency is missing! Please install Jobs and PlaceholderAPI!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        // Hooked
        getLogger().log(Level.INFO, "Hooked into Jobs and PlaceholderAPI plugins.");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().log(Level.INFO, "Unhooked from Jobs and PlaceholderAPI plugins.");
    }
}
