package org.geminicraft.betterwitch;

import org.geminicraft.betterwitch.cauldron.CauldronCache;
import org.geminicraft.betterwitch.cauldron.CauldronStorage;
import org.geminicraft.betterwitch.cauldron.events.CauldronInteract;
import org.geminicraft.betterwitch.cauldron.menu.CauldronRecipesMenu;
import org.geminicraft.betterwitch.commands.*;
import org.geminicraft.betterwitch.witches.events.WitchListener;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.plugin.SimplePlugin;


public class BetterWitchPlugin extends SimplePlugin {


    public CauldronStorage storage;
    public CauldronCache cache;

    @Override
    protected void onPluginStart() {
        this.storage = new CauldronStorage(this);
        storage.restoreMap();

        Common.log("Better Witches has started!");

        // Left this in for debug purposes
        // CauldronRegister register = CauldronRegister.getInstance();
        // register.getCauldronFoundationList();

        registerEvents(new CauldronRecipesMenu());
        registerEvents(new WitchListener());
        registerEvents(new CauldronInteract(this, storage, cache));
        registerCommand(new MenuCauldronSelect());
        registerCommand(new SpawnHusk());
        registerCommand(new SpawnWitch());
        registerCommand(new SpawnTestWitch());
        registerCommand(new GiveCauldron());
        registerCommand(new MenuRecipeSelect());

    }

    @Override
    protected void onPluginStop() {
        if (!storage.getStringLocationMap().isEmpty()) {
            Common.log("Storage was not empty!");

            storage.saveConfig();
        } else {
            Common.log("Okay, storage was empty.");
            Common.log(storage.getCauldronLocationMap().toString());
            Common.log("Above is result");

        }

    }
}
