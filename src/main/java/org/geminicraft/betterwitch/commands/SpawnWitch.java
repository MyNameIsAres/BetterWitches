package org.geminicraft.betterwitch.commands;

import net.minecraft.server.v1_16_R2.*;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R2.entity.CraftPlayer;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityTargetEvent;
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
        NewTestWitch witch = new NewTestWitch(location, "Charlie");


        Common.log(witch.getName() + " xxx");

        witch.setGoalTarget(((CraftPlayer) player).getHandle(), EntityTargetEvent.TargetReason.CUSTOM, true);


//        witch.setCustomName(new ChatComponentText(ChatColor.GREEN + "Nature Witch"));


        world.addEntity(witch, CreatureSpawnEvent.SpawnReason.CUSTOM);
//        world.addEntity(witch);
//        witch.spawnWitch(location);

        witch.spawnWitch(location);

        Common.log("Witch exists? " + witch);

        Common.tell(player, witch.getLocationGlobal() + " fetching location");


    }
}
