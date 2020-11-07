package org.geminicraft.betterwitch.cauldron.events;

import fr.xephi.authme.data.auth.PlayerCache;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.geminicraft.betterwitch.cauldron.CauldronBase;
import org.geminicraft.betterwitch.cauldron.tasks.CauldronChecker;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.remain.CompMaterial;
import org.mineacademy.fo.remain.CompMetadata;


public class CauldronInteract implements Listener {


    /*

        Create custom items: different cauldrons with different use cases
        Variants may include: for forest, fire, ice witch.

        We read from a config file and check if a key corresponds with a value
        between the cauldron and recipe. If they do, we go through
        that particular config section.

        We check for a flag of ordered. If the map in the list is required
        to be ordered, then the items have to go be 'placed' in a certain
        order.

        If the items have no order, we can listen for any variant.


        if (item "thrown" into cauldron == nether wart) {
            // we check for other items


        - order of items can be defined, but does not have to be.

        }

        left click = open gui
        right click = start a runnable thread that checks for the given item


        A thought:
        - Create a fake inventory that nobody can access, except for
        an administrator (for example).

        - Then as you right click the cauldron, the items are added.
        When you add an item it will go over the list of unsorted
        items in the config file.

        - We do not go over a list of sorted items, if the items we
        insert into the inventory does not correspond to the correct
        item (* the insertion order is incorrect*)
        


     */

    @EventHandler
    public void onCauldronInteract(final PlayerInteractEvent event) {

        final Player player = event.getPlayer();
        final Block block = event.getClickedBlock();
        final Action action = event.getAction();
        final ItemStack item = player.getInventory().getItemInMainHand();
        final int itemCount = player.getInventory().getItemInMainHand().getAmount();


        // TODO: Externalize the validation to their own private methods.
        try {
            if (action == Action.RIGHT_CLICK_BLOCK && block.getType() == CompMaterial.CAULDRON.getMaterial()
                    && event.getHand() == EquipmentSlot.HAND
                    && player.getInventory().getItemInMainHand().getType().equals(Material.NETHER_WART)) {
                Common.tell(player, "We clicked the right block.");
//                new CauldronChecker().run();


                if (itemCount >= 1) {
                    item.setAmount(itemCount - 1);
                    Common.tell(player, "Took one item");
                }


            } else {
                Common.log(block.getMetadata("key").toString());
                Common.log("This is the block: " + block);
            }
        } catch (NullPointerException exception) {
            Common.log("Null was thrown!");
        }

    }


}
