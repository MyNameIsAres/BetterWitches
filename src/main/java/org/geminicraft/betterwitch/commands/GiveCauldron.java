package org.geminicraft.betterwitch.commands;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.geminicraft.betterwitch.cauldron.CauldronBase;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.remain.CompMaterial;

public class GiveCauldron extends SimpleCommand {

    // TODO: Redesign after config + types are introduced
    public GiveCauldron() {
        super("cauldron");
    }

    // TODO: Better plan
    /*

       Create a GUI to create different cauldrons
       Each cauldron is created from a list of cauldrons where you loop over each individual  CauldronBase
       class. You then get properties like Name and other things from that list.
       Something like
       List<CauldronBase> cauldrons = new ArrayList<>;

       cauldrons.name
       cauldrons.lore



     */
    @Override
    protected void onCommand() {
        checkConsole();

        Common.log("Item Logged");

        CauldronBase base = new CauldronBase("Test");

        Common.log(base.getName());
//
//        final Player player = getPlayer();
//        CauldronBase cauldron = new CauldronBase(CompMaterial.CAULDRON.toItem(), "Test", new String[]{"Test"});
//
////        CauldronBase cauldron2 = new CauldronBase(CompMaterial.CAULDRON.toItem(), "Hello", new String[]{"Test"});
////        player.getInventory().addItem(test.getTestCauldron());
////        player.getInventory().addItem(test.getTestCauldron());
////        Common.log(test.getTestCauldron().getType().toString());
//
//
////        ItemCreator.of(CompMaterial.fromMaterial(cauldron.getCauldron().getType()),
////                "test",
////                "test").build().make();
//
//        cauldron.setCauldronNameFile("TEST");
//        cauldron.fetchCauldronFiles();
////        cauldron.fetchCauldronFiles();
////        cauldron2.setCauldronNameFile("somebodyoncetoldme");
//        player.getInventory().addItem(ItemCreator.of(CompMaterial.fromMaterial(cauldron.getCauldron().getType()),
//                cauldron.getName(),
//                cauldron.getLore()).build().make());

//        player.getInventory().addItem(ItemCreator.of(new CauldronBase(CompMaterial.CAULDRON.toItem(), "Test", "Some lore"));

//        Common.log(cauldron.toString());
    }
}
