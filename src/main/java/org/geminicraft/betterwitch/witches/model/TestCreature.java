package org.geminicraft.betterwitch.witches.model;

import lombok.SneakyThrows;
import net.minecraft.server.v1_16_R2.*;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R2.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_16_R2.entity.CraftWitch;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityTargetEvent;
import org.geminicraft.betterwitch.pathfinders.PathfinderGoalTest;
import org.geminicraft.betterwitch.witches.nmsgoals.GoalAdder;
import org.mineacademy.fo.Common;

import java.util.ArrayList;
import java.util.List;

@Deprecated
public class TestCreature extends EntityWitch {


    public TestCreature(Location location, Player player, String name, EntityType entityType) {


        super(EntityTypes.WITCH, ((CraftWorld) location.getWorld()).getHandle());
        GoalAdder test = new GoalAdder();
//        test.addPathfindersGoal(0, this, new PathfinderGoalTest(this, 1, 15));

        this.setPosition(location.getX(), location.getY(), location.getZ());

        this.setGoalTarget(((CraftPlayer) player).getHandle(), EntityTargetEvent.TargetReason.CUSTOM, true);
        Common.log("Created entity!");
    }

    @SneakyThrows
    @Override
    protected void initPathfinder() {
        GoalAdder goalAdder = new GoalAdder();

        // goalAdder.addPathfindersGoal(n, this.getBukkitEntity, pathfinder
        super.initPathfinder();
//        goalAdder.addPathfindersGoal(0, this, new PathfinderGoalTest(this, 1, 15));
//        goalAdder.addPathfinderGoals(0, this, new PathfinderGoalFloat(this));
//        this.goalSelector.a(0, new PathfinderGoalFloat(this));
//        this.goalSelector.a(1, new PathfinderGoalTest(this, 1, 15));

    }


}
