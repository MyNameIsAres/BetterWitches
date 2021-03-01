package org.geminicraft.betterwitch.cauldron.menu;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.ClickType;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.geminicraft.betterwitch.cauldron.CauldronCache;
import org.geminicraft.betterwitch.cauldron.CustomItem;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.menu.MenuPagged;
import org.mineacademy.fo.menu.model.ItemCreator;

import java.util.*;


public class CauldronRecipesMenu extends MenuPagged<CustomItem> implements Listener {

    @Getter
    @Setter
    public boolean hasClicked = false;


    @Setter
    public CauldronCache cauldronCache = new CauldronCache();


    public CauldronRecipesMenu() {
        super(9, null, CustomItem.getCustomItemStrictList(), true);

        setTitle("Possible recipes!");
    }

    int counter = -1;

    public void showInventory(CustomItem item, Player player) {

        Inventory inventory = Bukkit.createInventory(null, 9 * 2, "Test");

        for (Map.Entry<String, Object> entry : item.getRecipeMap().entrySet()) {
            counter++;

            int amount = (Integer) entry.getValue();
            Material material = Material.matchMaterial(entry.getKey());

            ItemStack stack = new ItemStack(material, amount);


            inventory.addItem(stack);

        }

        player.openInventory(inventory);
    }


    @Override
    protected ItemStack convertToItemStack(CustomItem item) {

        if (getViewer().getOpenInventory().getTitle().equals("Test")) {
            showInventory(item, getViewer());
        }

        return ItemCreator.of(item.getMaterial(), item.getName()).build().make();
    }

    @Override
    protected void onPageClick(Player player, CustomItem item, ClickType click) {

        if (click.isLeftClick()) {

            hasClicked = true;
            cauldronCache.setClickedItem(item);


            player.closeInventory();
        } else if (click.isRightClick()) {
            showInventory(item, player);
        } else {
            Common.log("Naaahh");
        }


    }

    public CauldronCache getCauldronCache() {
        return cauldronCache;
    }
}

