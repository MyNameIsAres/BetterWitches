package org.geminicraft.betterwitch.cauldron.menu;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.geminicraft.betterwitch.cauldron.CauldronBase;
import org.geminicraft.betterwitch.cauldron.CauldronRegister;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.menu.MenuPagged;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.remain.CompMaterial;

import java.util.List;

public class CauldronSelectMenu extends MenuPagged<CauldronBase> {

    public CauldronSelectMenu() {
        super(9 * 1, CauldronBase.getCauldronCollection());
        setTitle("Select a cauldron!");
    }


    @Override
    protected ItemStack convertToItemStack(CauldronBase item) {
//        CauldronRegister register = new CauldronRegister();
//        register.fetchCauldrons(item);
//
        CauldronBase base = new CauldronBase(item.getName());
        Common.log(item.getName());
//        base.fetchCauldronFiles();
        base.getCauldrons();


        return ItemCreator.of(CompMaterial.fromItem(CompMaterial.CAULDRON.toItem()),
                item.getName())
                .build().make();
    }

    @Override
    protected void onPageClick(Player player, CauldronBase item, ClickType click) {
        Common.log(item.toString());
    }
}
