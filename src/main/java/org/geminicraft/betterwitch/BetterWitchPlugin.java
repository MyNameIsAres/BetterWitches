package org.geminicraft.betterwitch;

import org.geminicraft.betterwitch.cauldron.events.CauldronInteract;
import org.geminicraft.betterwitch.commands.*;
import org.geminicraft.betterwitch.witches.events.WitchListener;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.plugin.SimplePlugin;


public class BetterWitchPlugin extends SimplePlugin {


    @Override
    protected void onPluginStart() {
        Common.log("Better Witches has started!");

        registerEvents(new WitchListener());
        registerEvents(new CauldronInteract());
        registerCommand(new MenuCauldronSelect());
        registerCommand(new SpawnHusk());
        registerCommand(new SpawnWitch());
        registerCommand(new SpawnTestWitch());
        registerCommand(new GiveCauldron());
    }


}
