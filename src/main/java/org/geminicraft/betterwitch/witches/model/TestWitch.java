package org.geminicraft.betterwitch.witches.model;

import net.minecraft.server.v1_16_R2.PathfinderGoal;
import net.minecraft.server.v1_16_R2.PathfinderGoalMeleeAttack;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R2.entity.CraftPlayer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityTargetEvent;
import org.mineacademy.fo.Common;

@Deprecated
public class TestWitch extends Witch {

    public TestWitch(String name, Location location) {
        super(name, location);
        this.setPosition(location.getX(), location.getY(), location.getZ());

    }


    @Override
    protected void initPathfinder() {
//
//        Witch x = new TestCreature()
//        Common.log("Hello darkness my old friend");
//        super.initPathfinder();
    }


}
