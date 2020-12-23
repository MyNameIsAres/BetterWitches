package org.geminicraft.betterwitch.cauldron;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class CauldronCache {

    @Getter
    @Setter
    CustomItem clickedItem;

    @Getter
    @Setter
    ItemStack testItem;


    @Getter
    @Setter
    public Map<ItemStack, Integer> map = new HashMap<>();


}
