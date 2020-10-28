package org.geminicraft.betterwitch.commands;

import net.minecraft.server.v1_16_R2.*;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R2.CraftWorld;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.geminicraft.betterwitch.witches.model.FirstTestWitch;
import org.geminicraft.betterwitch.witches.model.Witch;
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
//        final WorldServer world = ((CraftWorld) player.getWorld()).getHandle(); <-- Can be removed??
        final Witch firstTest = new FirstTestWitch(location, player, "test", EntityType.WITCH);

        firstTest.spawnWitch(location);
        player.sendMessage("Creature spawned");
    }
}
