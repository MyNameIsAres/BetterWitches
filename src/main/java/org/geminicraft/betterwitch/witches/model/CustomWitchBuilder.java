package org.geminicraft.betterwitch.witches.model;

import lombok.Getter;
import lombok.Setter;
import net.minecraft.server.v1_16_R2.PathfinderGoalSelector;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.geminicraft.betterwitch.FileHandable;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.collection.SerializedMap;
import org.mineacademy.fo.model.ConfigSerializable;
import org.mineacademy.fo.settings.SimpleYaml;
import org.mineacademy.fo.settings.YamlConfig;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/*

    * Complete the register and create a list of mobs that are loaded in.
    * Research advantage / disadvantage all mobs in one file, versus
    a file for each mob
    * Create a method to find a witch
    * When we find the witch, get their name, and use that to
    instantiate a CustomWitchBuilder object and fetch
    its necessary properties in a goal or target bit


    We have a given line with a priority, alias, and params:
    0 followPlayer ${speed=5 distance=6}
    or
    0 followPlayer {$speed=5 $distance=6}

    We take the substring of everything between the brackets, which leaves us
    with speed=5 distance=6



 */

public class CustomWitchBuilder extends YamlConfig {

    String key = "";

    @Setter
    @Getter
    private Map<String, String> paramMap = new ConcurrentHashMap<>();

    public CustomWitchBuilder(String name) {
        this.name = name;

        loadConfiguration(null, "custom-witches/" + name + (!name.endsWith(".yml") ? ".yml" : ""));

    }

    public String getKeyString(String input) {

        if (paramMap.containsKey(input)) {
            return paramMap.get(input);
        }

        return null;
    }

    public void getKeyAndValue(String params) {
        if (!params.startsWith("${") && !params.endsWith("}")) {
            Common.log("*ERROR* Incorrect parameter types");
        }

        this.key = params.substring(0, params.indexOf("{"));
        int startPosition = params.indexOf("{") + 1;
        int lastPosition = params.lastIndexOf("}");


        // This can bring over the params result to another method possibly
        params = params.substring(startPosition, lastPosition);

        String[] stringItems = params.split(" ");

        for (String item : stringItems) {
            String key = item.substring(0, item.indexOf("=")).trim().toLowerCase();
            String value = item.substring(item.indexOf("=") + 1).trim();

            paramMap.put(key, value);
        }
    }

    // Should be used when creating from the game only.
    public void setPrimaryTitle(String path) {
        if (isSet(path)) {
            getConfig().set(path, name);
        }
    }

    public ConfigurationSection getSection(String path) {
        if (isSet(path)) {
            return getConfig().getConfigurationSection(path);
        }
        return null;
    }

    public String getFileStringDefault(String path, String defaultValue) {
        if (isSet(path)) {
            return this.getConfig().getString(path, defaultValue);
        }
        return null;
    }

    public String getFileString(String path) {
        if (isSet(path)) {
            Common.log("path set");
            return this.getConfig().getString(path);
        }

        return null;
    }

    public Boolean getFileBoolean(String bool) {
        if (isSet(bool)) {
            return getConfig().getBoolean(String.valueOf(Boolean.parseBoolean(bool)));
        }

        return null;
    }

    public Double getFileDouble(String path) {
        if (isSet(path)) {
            return getConfig().getDouble(path);
//            return getConfig().getDouble(String.valueOf(Double.parseDouble(dub)));
        }

        return null;
    }

    public List<String> getFileStringList(String path) {
        if (isSet(path)) {
            return getConfig().getStringList(path);
        }

        return null;
    }

    public Integer getFileInteger(String path) {
        if (isSet(path)) {
            return getConfig().getInt(path);
        }
        return null;
    }

    public List<?> getFileList(String path) {
        if (isSet(path)) {
            return getConfig().getList(path);
        }

        return null;
    }

    public List<?> getFileMapList(String path) {
        if (isSet(path)) {
            return this.getConfig().getMapList(path);
        }

        return null;
    }

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private SimpleYaml simpleYaml;

    @Override
    protected void onLoadFinish() {
        name = getString("Name");


    }

}

