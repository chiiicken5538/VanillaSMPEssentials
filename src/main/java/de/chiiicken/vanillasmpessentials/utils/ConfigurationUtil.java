package de.chiiicken.vanillasmpessentials.utils;

import de.chiiicken.vanillasmpessentials.VanillaSMPEssentials;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

public class ConfigurationUtil {


    private final String fileName;

    public ConfigurationUtil(String fileName) {
        this.fileName = fileName;
    }

    public String getFormatedString(String path) {
        YamlConfiguration yamlConfiguration = new YamlConfiguration();
        try {
            yamlConfiguration.load(new File(VanillaSMPEssentials.getVanillaSMPEssentials().getDataFolder(), this.fileName));
        } catch (IOException | InvalidConfigurationException e) {
            throw new RuntimeException(e);
        }
        return yamlConfiguration.getString(path).replace("%prefix%", VanillaSMPEssentials.getVanillaSMPEssentials().getConfig().getString("messages.prefix")).replace("&", "§");
    }

    public String getString(String path) {
        YamlConfiguration yamlConfiguration = new YamlConfiguration();
        try {
            yamlConfiguration.load(new File(VanillaSMPEssentials.getVanillaSMPEssentials().getDataFolder(), this.fileName));
        } catch (IOException | InvalidConfigurationException e) {
            throw new RuntimeException(e);
        }
        return yamlConfiguration.getString(path);
    }

    public Integer getInt(String path) {
        YamlConfiguration yamlConfiguration = new YamlConfiguration();
        try {
            yamlConfiguration.load(new File(VanillaSMPEssentials.getVanillaSMPEssentials().getDataFolder(), this.fileName));
        } catch (IOException | InvalidConfigurationException e) {
            throw new RuntimeException(e);
        }
        return yamlConfiguration.getInt(path);
    }

    public Boolean getBoolean(String path) {
        YamlConfiguration yamlConfiguration = new YamlConfiguration();
        try {
            yamlConfiguration.load(new File(VanillaSMPEssentials.getVanillaSMPEssentials().getDataFolder(), this.fileName));
        } catch (IOException | InvalidConfigurationException e) {
            throw new RuntimeException(e);
        }
        return yamlConfiguration.getBoolean(path);
    }

    public Location getLocation(String parentPath) {
        YamlConfiguration yamlConfiguration = new YamlConfiguration();
        try {
            yamlConfiguration.load(new File(VanillaSMPEssentials.getVanillaSMPEssentials().getDataFolder(), this.fileName));
        } catch (IOException | InvalidConfigurationException e) {
            throw new RuntimeException(e);
        }
        return new Location(
                Bukkit.getServer().getWorld((String) yamlConfiguration.get(parentPath + ".world")),
                (double) yamlConfiguration.get(parentPath + ".x"),
                (double) yamlConfiguration.get(parentPath + ".y"),
                (double) yamlConfiguration.get(parentPath + ".z"),
                (float) (double) yamlConfiguration.get(parentPath + ".yaw"),
                (float) (double) yamlConfiguration.get(parentPath + ".pitch"));
    }
    public YamlConfiguration initializeConfigurationFile() {
        File file = new File(VanillaSMPEssentials.getVanillaSMPEssentials().getDataFolder(), this.fileName);

        if (!file.exists()) {
            if (file.getParentFile().mkdirs()) {
                VanillaSMPEssentials.getVanillaSMPEssentials().saveResource(fileName, false);
            } else {
                VanillaSMPEssentials.getVanillaSMPEssentials().saveResource(fileName, false);
            }
        }
        YamlConfiguration yamlConfiguration = new YamlConfiguration();
        try {
            yamlConfiguration.load(file);
            return yamlConfiguration;
        } catch (IOException | InvalidConfigurationException e) {
            throw new RuntimeException(e);
        }
    }
}
