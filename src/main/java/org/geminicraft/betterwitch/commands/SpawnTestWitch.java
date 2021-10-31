package org.geminicraft.betterwitch.commands;

import com.palmergames.bukkit.towny.object.Nation;
import com.sk89q.worldguard.protection.regions.ProtectedCuboidRegion;
import net.minecraft.server.v1_16_R2.WorldServer;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R2.CraftWorld;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
//import org.geminicraft.betterwitch.witches.model.TestWitch;
//import org.geminicraft.betterwitch.witches.model.TestWitch;
import org.geminicraft.betterwitch.witches.model.Witch;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.collection.expiringmap.ExpiringMap;
import org.mineacademy.fo.command.SimpleCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SpawnTestWitch extends SimpleCommand {


    public SpawnTestWitch() {
        super("witchtest");
        setMinArguments(1);
    }

    @Override
    protected void onCommand() {
        checkConsole();

        String test = "";

        
        final String param = args[0].toLowerCase();


        if ("confirm".equals(param)) {
            Common.log(test + " this is test");

            return;
        }

        final Nation nation = Nation.findNation(param);
        // just testing

        test = param;
        Common.log(test + " see if this exists");


        checkNotNull(nation, "Hey, this nation does not exist!");

    }


    private void teleportToNation(final Player player, final Nation nation) {
        player.teleport(nation.getNationLocation());
    }

    static class Nation {

        public static Nation findNation(String param) {
            return null;
        }

        public Location getNationLocation() {
            return null;
        }
    }
}
