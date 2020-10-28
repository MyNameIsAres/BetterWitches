package org.geminicraft.betterwitch.commands;

import net.minecraft.server.v1_16_R2.ChatComponentText;
import net.minecraft.server.v1_16_R2.WorldServer;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R2.CraftWorld;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.geminicraft.betterwitch.witches.model.TestCreature;
import org.geminicraft.betterwitch.witches.model.Witch;
import org.mineacademy.fo.command.SimpleCommand;

public class SpawnHusk extends SimpleCommand {

    public SpawnHusk() {
        super("husk");
    }

    @Override
    protected void onCommand() {
        checkConsole();

        final Player player = getPlayer();
        final Location location = player.getLocation();
        final WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
        final Witch witch = new TestCreature(location, player, "test", EntityType.WITCH);
        witch.setCustomName(new ChatComponentText(ChatColor.RED + player.getName() + "'s pet."));

        world.addEntity(witch);

        player.sendMessage("Creature HUSK spawned");
    }
}

