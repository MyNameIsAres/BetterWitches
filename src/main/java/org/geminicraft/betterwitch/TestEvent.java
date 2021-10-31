package org.geminicraft.betterwitch;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.mineacademy.fo.Common;

public class TestEvent implements Listener {

    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        PersistentDataContainer dataContainer = event.getEntity().getPersistentDataContainer();
//        Common.log(dataContainer.getKeys() + " keys");
//        Common.log(dataContainer.getAdapterContext().toString() + " context");
//
//        Common.log(dataContainer + " container");
//        Common.log(dataContainer.toString() + " container");
//
//
//        Common.log("test");


    }


}
