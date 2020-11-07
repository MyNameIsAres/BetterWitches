package org.geminicraft.betterwitch.witches.model;

import net.minecraft.server.v1_16_R2.*;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R2.entity.CraftPlayer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityTargetEvent;
import org.geminicraft.betterwitch.pathfinders.PathfinderGoalTest;
import org.mineacademy.fo.Common;

public class TestCreature extends Witch {


    public TestCreature(Location location, Player player, String name, EntityType entityType) {
        super(location, player, name, entityType);
        this.setPosition(location.getX(), location.getY(), location.getZ());

        this.setGoalTarget(((CraftPlayer) player).getHandle(), EntityTargetEvent.TargetReason.CUSTOM, true);
        Common.log("Created entity!");
    }

    @Override
    protected void initPathfinder() {
        super.initPathfinder();
        this.goalSelector.a(0, new PathfinderGoalFloat(this));
        this.goalSelector.a(1, new PathfinderGoalTest(this, 1, 15));

    }
}
