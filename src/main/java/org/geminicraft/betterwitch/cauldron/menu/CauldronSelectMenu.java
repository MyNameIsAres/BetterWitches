package org.geminicraft.betterwitch.cauldron.menu;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.geminicraft.betterwitch.cauldron.CauldronFoundation;
import org.geminicraft.betterwitch.cauldron.CauldronRegister;
import org.mineacademy.fo.menu.MenuPagged;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.remain.CompMaterial;
import org.mineacademy.fo.remain.CompMetadata;

public class CauldronSelectMenu extends MenuPagged<CauldronFoundation> {

    public CauldronSelectMenu() {
        super(9 * 1, CauldronRegister.getInstance().getCauldronBaseList());
        setTitle("Select a cauldron!");
    }

    @Override
    protected ItemStack convertToItemStack(CauldronFoundation item) {
        return ItemCreator.of(CompMaterial.CAULDRON, item.getName()).build().make();
    }

    @Override
    protected void onPageClick(Player player, CauldronFoundation item, ClickType click) {
        ItemStack itemStack = ItemCreator.of(CompMaterial.CAULDRON, item.getName()).build().make();
        ItemMeta meta = itemStack.getItemMeta();
        meta.setDisplayName(item.getName());

        CompMetadata.setMetadata(itemStack, "cauldron", "something");

        player.getInventory().addItem(itemStack);
    }
}
