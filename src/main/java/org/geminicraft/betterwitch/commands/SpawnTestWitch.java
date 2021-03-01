package org.geminicraft.betterwitch.commands;

import net.minecraft.server.v1_16_R2.WorldServer;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R2.CraftWorld;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
//import org.geminicraft.betterwitch.witches.model.TestWitch;
import org.geminicraft.betterwitch.witches.model.TestWitch;
import org.geminicraft.betterwitch.witches.model.Witch;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;

public class SpawnTestWitch extends SimpleCommand {

    public SpawnTestWitch() {
        super("witchtest");
    }

    @Override
    protected void onCommand() {
        checkConsole();
        final Player player = getPlayer();
        final Location location = player.getLocation();
        final WorldServer world = ((CraftWorld) player.getWorld()).getHandle();

        final Witch test = new TestWitch("test", player.getLocation());
        world.addEntity(test);


        Common.tell(player, "Test Witch spawned");
    }
}
