package org.geminicraft.betterwitch;

import org.geminicraft.betterwitch.commands.*;
//import org.geminicraft.betterwitch.reflections.Reflections;
import org.geminicraft.betterwitch.reflections.Reflections;
import org.geminicraft.betterwitch.witches.WitchPotionEffect;
import org.geminicraft.betterwitch.witches.WitchRegister;
import org.geminicraft.betterwitch.witches.abilities.WitchAbilities;
import org.geminicraft.betterwitch.witches.events.WitchListener;

import org.geminicraft.betterwitch.witches.model.GoalsInterface;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.plugin.SimplePlugin;

import java.util.*;

public class BetterWitchPlugin extends SimplePlugin {


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

//        registerEvents(new TestEvent());

        registerEvents(new WitchListener());

        registerCommand(new SpawnHusk());
        registerCommand(new SpawnWitch());
        registerCommand(new SpawnTestWitch());


    }
}
