package org.geminicraft.betterwitch.witches.model;

import net.minecraft.server.v1_16_R2.*;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityTargetEvent;
import org.geminicraft.betterwitch.Pathfinders.PathfinderGoalTest;
import org.mineacademy.fo.Common;

public class TestCreature extends EntityZombieHusk {


    public TestCreature(Location location, Player player) {
        super(EntityTypes.HUSK, ((CraftWorld) location.getWorld()).getHandle());

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
