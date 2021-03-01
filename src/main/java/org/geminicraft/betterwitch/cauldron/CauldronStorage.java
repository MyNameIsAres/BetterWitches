package org.geminicraft.betterwitch.cauldron;

import lombok.Getter;
import lombok.Setter;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.geminicraft.betterwitch.BetterWitchPlugin;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.collection.SerializedMap;
import org.mineacademy.fo.model.ConfigSerializable;
import org.mineacademy.fo.settings.YamlConfig;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CauldronStorage {

    @Getter
    @Setter
    Map<Location, String> cauldronLocationMap = new HashMap<>();

    @Getter
    @Setter
    Map<String, List<Location>> testMap = new HashMap<>();

    @Getter
    @Setter
    Map<String, String> stringLocationMap = new HashMap<>();

    private BetterWitchPlugin plugin;
    private FileConfiguration configuration = null;
    private File configFile = null;
    private final String FILE = "cauldron-locations.yml";

    public CauldronStorage(BetterWitchPlugin plugin) {
        this.plugin = plugin;
        saveDefaultConfig();
    }

    public void reloadConfig() {
        if (this.configFile == null) {
            Common.log("Assuming this runs as it is null");
            this.configFile = new File(this.plugin.getDataFolder(), FILE);
        }

        this.configuration = YamlConfiguration.loadConfiguration(this.configFile);
        InputStream defaultStream = this.plugin.getResource(FILE);

        if (defaultStream != null) {
            YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream));
            this.configuration.setDefaults(defaultConfig);
        }
    }

    public FileConfiguration getConfig() {
        if (this.configuration == null) {
            Common.log("getConfig thing is null");
            reloadConfig();
        }

        return this.configuration;
    }

    // Causes error if it's null
//    public void restoreMap() {
//        this.getConfig().getConfigurationSection("cauldrons").getValues(true).forEach((key, value) -> {
//            getStringLocationMap().put(key, value.toString());
//        });
//    }

    public Location getLocationString(final String s) {
//        if (s == null || s.trim() == "") {
//            return null;
//        }
        final String[] parts = s.split("\\\\");
        if (parts.length == 4) {
            final World w = Bukkit.getServer().getWorld(parts[0]);
            final int x = Integer.parseInt(parts[1]);
            final int y = Integer.parseInt(parts[2]);
            final int z = Integer.parseInt(parts[3]);
            return new Location(w, x, y, z);
        }
        return null;
    }


    public void fetchBlockData() {
        for (String keys : getConfig().getConfigurationSection("cauldrons").getKeys(false)) {
            testMap.put(keys, (List<Location>) getConfig().getList("cauldrons." + keys));

            Common.log(keys + " These are the keys");
        }
    }

    public void fetchMap() {
        Common.log("Fetching now");
        for (Map.Entry<String, String> entry : getStringLocationMap().entrySet()) {
//            Common.log("Key" + entry.getKey());
//            Common.log("Value" + entry.getValue());
        }

        Common.log("Finished fetching");
    }

    public void saveConfig() {
        Common.log("Entering save config");
//        if (this.configuration == null || this.configFile == null) {
//            Common.log("this is null??");
//            reloadConfig();
//            getConfig();
//
//            Common.log("Is it still null after this");
//            return;
//        }

        Common.log("It was not null");

        try {
            for (Map.Entry<String, String> entry : getStringLocationMap().entrySet()) {
                this.getConfig().set("cauldrons." + entry.getKey(), entry.getValue());
                this.getConfig().save(this.configFile);

                Common.log("We are saving a bunch of times");
            }
        } catch (IOException exception) {
            Common.log(exception.toString());
        }
    }

    public void saveDefaultConfig() {
        if (this.configFile == null) {
            this.configFile = new File(this.plugin.getDataFolder(), FILE);
        }

        if (!this.configFile.exists()) {
            this.plugin.saveResource(FILE, false);
        }
    }


    //
//    @Getter
//    @Setter
//    Map<Location, String> map = new HashMap<>();
//
//    public Location location;
//    public String name;
//
//    public CauldronStorage() {
//
//        loadConfiguration(null, "cauldron-location.yml");
//    }
//
//    @Override
//    protected void onLoadFinish() {
//        location = getLocation("Location");
//        name = getString("Name");
//    }
//
//    public void getAllItems() {
//        for (Map.Entry<Location, String> entry : map.entrySet()) {
//            Common.log("Key: " + entry.getKey().getWorld());
//            Common.log("Value" + entry.getValue());
//        }
//    }
//
//    @Override
//    public SerializedMap serialize() {
//        SerializedMap serializedMap = new SerializedMap();
//
//        for (Map.Entry<Location, String> entry : map.entrySet()) {
//            Common.log("Hey! I am interating");
//            serializedMap.put("Location", entry.getKey());
//            serializedMap.put("Name", entry.getValue());
//
//            Common.log("Name" + entry.getKey());
//        }
//        Common.log("We are serializing");
//
//        return serializedMap;
//    }
}
