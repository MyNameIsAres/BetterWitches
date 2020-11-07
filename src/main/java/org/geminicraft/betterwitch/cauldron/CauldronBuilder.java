package org.geminicraft.betterwitch.cauldron;


import org.bukkit.inventory.ItemStack;

/*
   +setName()/getName()
        +setLore()/getLore()
        +setAllowedItems()/getAllowedItems()
        +setOrderedCombinations/getOrderedCombinations()
        +setUnorderedCombinations/getUnorderedCombinations()
        +setCustomItem()/getCustomItem()


 */
public interface CauldronBuilder {

    void setName(String name);

    String getName();

    void setLore(String[] lore);

    String[] getLore();

    void setAllowedItems(ItemStack items);

    ItemStack getAllowedItems();

    void setCustomItem(ItemStack items);

    ItemStack getCustomItem();

    void setOrderedCombination(ItemStack items);

    ItemStack getOrderedCombination(ItemStack items);

    void setUnorderedCombinations(ItemStack items);

    ItemStack getUnorderedCombinations();

}
