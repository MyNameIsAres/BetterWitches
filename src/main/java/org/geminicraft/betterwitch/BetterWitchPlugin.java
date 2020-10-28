package org.geminicraft.betterwitch;

import org.geminicraft.betterwitch.commands.SpawnHusk;
import org.geminicraft.betterwitch.commands.SpawnTestWitch;
import org.geminicraft.betterwitch.commands.SpawnWitch;
import org.geminicraft.betterwitch.witches.events.WitchListener;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.plugin.SimplePlugin;


public class BetterWitchPlugin extends SimplePlugin {


    @Override
    protected void onPluginStart() {
        Common.log("Better Witches has started!");

        registerEvents(new WitchListener());
        
        registerCommand(new SpawnHusk());
        registerCommand(new SpawnWitch());
        registerCommand(new SpawnTestWitch());
    }


}
