package org.geminicraft.betterwitch.commands;

import org.geminicraft.betterwitch.BetterWitchPlugin;
import org.geminicraft.betterwitch.cauldron.CauldronRegister;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;

public class GiveCauldron extends SimpleCommand {

    BetterWitchPlugin plugin;

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

//        CauldronStorage storage = new CauldronStorage(plugin);
//
//        storage.fetchMap();

//        cache.getCauldronMap();

        Common.log("Item Logged");
        CauldronRegister register = CauldronRegister.getInstance();
        final String param = args[0].toLowerCase();

        if ("new".equals(param)) {
            checkArgs(2, "You must also set the class name");
            final String className = args[1];

            Common.log(className);

//            CauldronRegister register = CauldronRegister.getInstance();
            register.addToStrictList(className);


            tell("&6Class " + className + " has been created!");

        }


//        register.getListCount();

//====================================


//        CauldronBase base = new CauldronBase("Test");
//
////        base.addToList(base);
////
//        base.setCauldronNameFile(base.getName());
//
//        base.fetchCauldronFiles(base);
//
//        Common.log(base.getName());


//        ItemCreator.of(new CauldronBase()).build().make();
//
//        Common.log(base.getName());
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
