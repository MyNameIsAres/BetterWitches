package org.geminicraft.betterwitch.witches.model;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.configuration.ConfigurationSection;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.settings.SimpleYaml;
import org.mineacademy.fo.settings.YamlConfig;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CustomWitchBuilder extends YamlConfig {
    
    public CustomWitchBuilder(String name) {
        this.name = name;

        loadConfiguration(null, "custom-witches/" + name + (!name.endsWith(".yml") ? ".yml" : ""));

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

