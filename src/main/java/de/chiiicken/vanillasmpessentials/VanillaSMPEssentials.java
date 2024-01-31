package de.chiiicken.vanillasmpessentials;

import de.chiiicken.vanillasmpessentials.utils.ConfigurationUtil;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class VanillaSMPEssentials extends JavaPlugin {

    private static VanillaSMPEssentials vanillaSMPEssentials;
    private static FileConfiguration config;

    @Override
    public void onEnable() {
        vanillaSMPEssentials = this;

        config = new ConfigurationUtil("config.yml").initializeConfigurationFile();

        Bukkit.getConsoleSender().sendMessage(getMessagePrefix() + "§aPlugin initialized successfully.");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(getMessagePrefix() + "§7goodbye!");
    }

    public static VanillaSMPEssentials getVanillaSMPEssentials() {
        return vanillaSMPEssentials;
    }

    public FileConfiguration getConfigFileConfiguration() {
        return config;
    }

    public String getMessagePrefix() {
        return getConfigFileConfiguration().getString("messages.prefix").replace("&", "§") + " §7";
    }
}
