package org.geminicraft.betterwitch.commands;

import net.minecraft.server.v1_16_R2.*;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R2.CraftWorld;
import org.bukkit.entity.Player;
import org.geminicraft.betterwitch.witches.model.*;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;

public class SpawnWitch extends SimpleCommand {


    public SpawnWitch() {
        super("witch");
    }

    @Override
    protected void onCommand() {
        checkConsole();

        final Player player = getPlayer();
        final Location location = player.getLocation();
        final WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
        NewTestWitch witch = new NewTestWitch(location, "Charlie", player);


//        witch.setCustomName(new ChatComponentText(ChatColor.GREEN + "Nature BITCH"));

        Common.log(player + " player ");

        world.addEntity(witch);
//        witch.spawnWitch(location);
        Common.log("New Witch");


    }
}
