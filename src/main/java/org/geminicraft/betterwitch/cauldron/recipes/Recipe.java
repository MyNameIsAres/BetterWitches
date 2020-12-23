package org.geminicraft.betterwitch.cauldron.recipes;

import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class Recipe {

    final Map<ItemStack, Integer> recipeMap = new HashMap<>();

    public void addToMap(ItemStack item, Integer amount) {
        recipeMap.put(item, amount);
    }


}
