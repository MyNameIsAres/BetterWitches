package org.geminicraft.betterwitch.cauldron;

import lombok.Getter;
import lombok.Setter;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.collection.StrictList;
import org.mineacademy.fo.model.SimpleEnchantment;
import org.mineacademy.fo.remain.CompMaterial;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomItem {
    // TODO: Add enchantments, fix up code.

    @Getter
    @Setter
    public static StrictList<CustomItem> customItemStrictList = new StrictList<>();

    public void addToCustomItemStrictList(CustomItem item) {
        customItemStrictList.add(item);
    }

    public static CustomItem findCustomItem(CustomItem customItem) {
        for (CustomItem item : customItemStrictList) {
            if (customItem.getName().equals(item.getName())) {
                return item;
            }
        }

        return null;
    }

    // Utility method for testing
    public CustomItem iterateStrictList() {
        for (CustomItem item : customItemStrictList) {
            return item;
        }
        return null;
    }

    @Getter
    @Setter
    public CustomItem selectedItem;


    @Getter
    public Map<String, Object> recipeMap = new HashMap<>();

    public void addToRecipeMap(String recipeMaterial, Object amount) {
        recipeMap.put(recipeMaterial, amount);
    }

    public void removeFromRecipeMap() {
        // remove from map
    }

    public void fetchRecipeMap() {
        // iterate over map
    }

    public void testFunctionFetchMaterial() {

    }

    @Getter
    @Setter
    public String name;

    @Getter
    @Setter
    public List<String> lore;

    @Getter
    @Setter
    public CompMaterial material;

    @Getter
    @Setter
    public SimpleEnchantment[] enchantments;

    public CustomItem(String name, List<String> lore, CompMaterial material) {
        this.name = name;
        this.lore = lore;
        this.material = material;
    }
}

