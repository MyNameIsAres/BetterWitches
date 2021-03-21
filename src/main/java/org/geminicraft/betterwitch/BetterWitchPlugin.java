package org.geminicraft.betterwitch;

import org.geminicraft.betterwitch.cauldron.CauldronCache;
import org.geminicraft.betterwitch.cauldron.CauldronRegister;
import org.geminicraft.betterwitch.cauldron.CauldronStorage;
import org.geminicraft.betterwitch.cauldron.events.CauldronInteract;
import org.geminicraft.betterwitch.cauldron.menu.CauldronRecipesMenu;
import org.geminicraft.betterwitch.commands.*;

//import org.geminicraft.betterwitch.reflections.Reflections;
import org.geminicraft.betterwitch.reflections.Reflections;
import org.geminicraft.betterwitch.witches.WitchPotionEffect;
import org.geminicraft.betterwitch.witches.WitchRegister;
import org.geminicraft.betterwitch.witches.abilities.WitchAbilities;
import org.geminicraft.betterwitch.witches.events.WitchListener;

import org.geminicraft.betterwitch.witches.model.GoalsInterface;
import org.mineacademy.fo.Common;
//import org.mineacademy.fo.ReflectionUtil;
import org.mineacademy.fo.plugin.SimplePlugin;

//
//import java.io.File;
//import java.lang.reflect.Field;
//import java.net.URL;
import java.util.*;


public class BetterWitchPlugin extends SimplePlugin {
    public CauldronStorage storage;
    public CauldronCache cache;


    @Override
    protected void onPluginStart() {

        Common.log("########################");
        Common.log("Creating the witches now!");
        WitchRegister.fetchNames();
        Common.log("########################");
        Common.log(" ");
        Common.log("########################");
        WitchRegister.getInstance().loadWitches();
        Common.log("########################");
        Common.log(" ");
        Common.log("########################");
        Common.log("Testing for witches now!");
        WitchRegister.getInstance().testForWitches();
        Common.log("########################");


//        this.storage = new CauldronStorage(this);
//        storage.restoreMap();

        Common.log("Better Witches has started!");
        Common.log("JUST TO CONFIRM THIS IS LOADING");

        // Left this in for debug purposes
        CauldronRegister register = CauldronRegister.getInstance();

        register.getCauldronFoundationList();

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

    // TODO: Refactor / implement new version on Cauldron update
    @Override
    protected void onPluginStop() {
//        if (!storage.getStringLocationMap().isEmpty()) {
//            Common.log("Storage was not empty!");
//
//            storage.saveConfig();
//        } else {
//            Common.log("Okay, storage was empty.");
//            Common.log(storage.getCauldronLocationMap().toString());
//            Common.log("Above is result");
//
//        }

    }
}
