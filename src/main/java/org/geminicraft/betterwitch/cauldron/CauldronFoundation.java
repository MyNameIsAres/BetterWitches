package org.geminicraft.betterwitch.cauldron;

import lombok.Getter;
import lombok.Setter;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.collection.SerializedMap;
import org.mineacademy.fo.model.ConfigSerializable;
import org.mineacademy.fo.remain.CompMaterial;
import org.mineacademy.fo.settings.YamlConfig;

import java.util.List;

public class CauldronFoundation extends YamlConfig {


    @Getter
    public String name;

    public void setName(String name) {
        this.name = name;

        save("Name", name);
    }

    @Getter
    @Setter
    public static String customFileName;

    @Setter
    @Getter
    public String[] lore;

    @Setter
    @Getter
    public CompMaterial material;

    public Object test;

    public CauldronFoundation(String name) {
        this.name = name;

        loadConfiguration("cauldron-config.yml", "cauldrons/" + name + (!name.endsWith(".yml") ? ".yml" : ""));
    }

    @Override
    protected void onLoadFinish() {
        name = getString("Name");
        lore = getStringArray("Lore");

        
        if (isSet("Recipes")) {
            final List<SerializedMap> testList = getMapList("Recipes");

            for (final SerializedMap something : testList) {
                Common.log("This is something" + something);
                SerializedMap map = something.getMap("RecipeItems");

                final String name = something.getString("RecipeItem");
                final List<String> lore = something.getStringList("Lore");
                final CompMaterial material = something.getMaterial("Material");
                final List<String> enchantments = something.getStringList("Enchantments");

                CustomItem customItem = new CustomItem(name, lore, material);
                Common.log(map.toString());
                customItem.addToCustomItemStrictList(customItem);

            }
        } else {
            Common.log("Testing this");
        }

    }

//    @Override
//    public SerializedMap serialize() {
//        final SerializedMap map = new SerializedMap();
//
//        map.put("Name", name);
//        map.put("Lore", lore);
//        map.put("TestItem", Recipe.class);
//
//        return map;
//    }
//
//    public static class Recipe implements ConfigSerializable {
//
//        @Override
//        public SerializedMap serialize() {
//            Common.log("At least we tried to serialize this");
//            SerializedMap map = new SerializedMap();
//
//            map.put("this", "that");
//
//            return map;
//        }
//    }

}
