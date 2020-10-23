package org.geminicraft.betterwitch;

import org.bukkit.entity.Player;
import org.geminicraft.betterwitch.commands.SpawnHusk;
import org.geminicraft.betterwitch.commands.SpawnWitch;
import org.geminicraft.betterwitch.witches.model.Witch;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.plugin.SimplePlugin;


public class BetterWitchPlugin extends SimplePlugin {


    @Override
    protected void onPluginStart() {
        Common.log("Better Witches has started!");


        registerCommand(new SpawnWitch());
        registerCommand(new SpawnHusk());
    }


}
