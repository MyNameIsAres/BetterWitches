package org.geminicraft.betterwitch;

import com.earth2me.essentials.Essentials;
import com.google.common.reflect.Reflection;

import net.minecraft.server.v1_16_R2.EntityInsentient;
import net.minecraft.server.v1_16_R2.EntityWitch;
import net.minecraft.server.v1_16_R2.PathfinderGoal;
import net.minecraft.server.v1_16_R2.PathfinderGoalFloat;

import org.bukkit.Location;
import org.geminicraft.betterwitch.cauldron.CauldronCache;
import org.geminicraft.betterwitch.cauldron.CauldronRegister;
import org.geminicraft.betterwitch.cauldron.CauldronStorage;
import org.geminicraft.betterwitch.cauldron.events.CauldronInteract;
import org.geminicraft.betterwitch.cauldron.menu.CauldronRecipesMenu;
import org.geminicraft.betterwitch.commands.*;

//import org.geminicraft.betterwitch.reflections.Reflections;
import org.geminicraft.betterwitch.reflections.Reflections;
import org.geminicraft.betterwitch.util.TestFeatures;
import org.geminicraft.betterwitch.witches.WitchPotionEffect;
import org.geminicraft.betterwitch.witches.abilities.WitchAbilities;
import org.geminicraft.betterwitch.witches.events.WitchListener;

import org.geminicraft.betterwitch.witches.model.GoalsInterface;
import org.mineacademy.fo.Common;
//import org.mineacademy.fo.ReflectionUtil;
import org.mineacademy.fo.plugin.SimplePlugin;

//
//import java.io.File;
//import java.lang.reflect.Field;
//import java.net.URL;
import java.util.*;


public class BetterWitchPlugin extends SimplePlugin {
    public CauldronStorage storage;
    public CauldronCache cache;


//    Map<Integer, PathfinderGoal> map = new HashMap<>();
//
//    public void addToMap(int priority, PathfinderGoal goal) {
//        map.put(priority, goal);
//    }
//
//    public void loopOver() {
//        map.forEach((priority, goal) -> {
//            Common.log(goal.toString() + " I am the goal");
//
//        });
//    }

    @Override
    protected void onPluginStart() {
//        Reflections fu = new Reflections();


//        Reflections reflections = new Reflections("org.geminicraft.betterwitch.witches.model");
//
//        Reflections reflections = new Reflections("org.geminicraft.betterwitch.witches.model");
//        Set<Class<? extends GoalsInterface>> classes = reflections.getSubTypesOf(GoalsInterface.class);
//        Common.log(classes + " classes");
//
//        Package test = BetterWitchPlugin.class.getPackage();
//        Common.log(test + " test");


//        Reflections reflections = new Reflections("org.geminicraft.betterwitch.witches.model");

//        Reflections reflections = new Reflections("org.geminicraft.betterwitch.witches.model");
//        Set<Class<? extends GoalsInterface>> classes = reflections.getSubTypesOf(GoalsInterface.class);
//        Common.log(classes + " classes");
//
//        this.storage = new CauldronStorage(this);
//        storage.restoreMap();

        Common.log("Better Witches has started!");
        Common.log("JUST TO CONFIRM THIS IS LOADING");

        // Left this in for debug purposes
        CauldronRegister register = CauldronRegister.getInstance();

        register.getCauldronFoundationList();

        registerEvents(new CauldronRecipesMenu());
        registerEvents(new WitchListener());
        registerEvents(new CauldronInteract(this, storage, cache));
        registerCommand(new MenuCauldronSelect());
        registerCommand(new SpawnHusk());
        registerCommand(new SpawnWitch());
        registerCommand(new SpawnTestWitch());
        registerCommand(new GiveCauldron());
        registerCommand(new MenuRecipeSelect());


    }

    @Override
    protected void onPluginStop() {
//        if (!storage.getStringLocationMap().isEmpty()) {
//            Common.log("Storage was not empty!");
//
//            storage.saveConfig();
//        } else {
//            Common.log("Okay, storage was empty.");
//            Common.log(storage.getCauldronLocationMap().toString());
//            Common.log("Above is result");
//
//        }

    }
}
