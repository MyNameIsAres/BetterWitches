package org.geminicraft.betterwitch.tester;

import org.mineacademy.fo.Common;
import org.mineacademy.fo.plugin.SimplePlugin;

public class MainPlugin extends SimplePlugin {

    @Override
    protected void onPluginStart() {
        Common.log("This is loaded");
    }


}
