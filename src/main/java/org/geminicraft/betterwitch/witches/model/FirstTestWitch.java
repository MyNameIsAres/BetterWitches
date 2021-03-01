package org.geminicraft.betterwitch.witches.model;


import net.minecraft.server.v1_16_R2.PathfinderGoalFloat;
import org.bukkit.Location;

import org.bukkit.craftbukkit.v1_16_R2.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_16_R2.entity.CraftWitch;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityTargetEvent;

import org.geminicraft.betterwitch.witches.abilities.LightningAbility;

@Deprecated
public class FirstTestWitch extends Witch {

    public FirstTestWitch(String name, Location location) {
        super(name, location);
//        GoalAdder goalAdder = new GoalAdder();
//        goalAdder.addPathfindersGoal(0, CraftWitch.class, new PathfinderGoalFloat(this));
        this.setPosition(location.getX(), location.getY(), location.getZ());
//        this.setGoalTarget(((CraftPlayer) player).getHandle(), EntityTargetEvent.TargetReason.CUSTOM, true);
        addAbility(new LightningAbility());

    }


}
