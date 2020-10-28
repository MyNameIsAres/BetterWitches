package org.geminicraft.betterwitch.cauldron.events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.mineacademy.fo.Common;


public class CauldronInteract implements Listener {

    @EventHandler
    public void onCauldronInteract(final PlayerInteractEvent event) {
        final Player player = event.getPlayer();
        final Block block = event.getClickedBlock();
        final Action action = event.getAction();

        try {
            if (action == Action.RIGHT_CLICK_BLOCK && block.getType() == Material.CAULDRON) {
                Common.tell(player, "We clicked the right block.");
            }
        } catch (NullPointerException exception) {
            Common.log("Null was thrown!");
        }

    }


}
