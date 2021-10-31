package org.geminicraft.betterwitch.witches.nmsgoals;


import lombok.Getter;
import net.minecraft.server.v1_16_R2.EntityInsentient;
import net.minecraft.server.v1_16_R2.PathfinderGoal;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.entity.EntityTargetEvent;
import org.geminicraft.betterwitch.AIGoalsAnnotation;
import org.geminicraft.betterwitch.ParamsFileHandler;
import org.geminicraft.betterwitch.pathfinders.PathfinderGoalTest;
import org.geminicraft.betterwitch.witches.WitchRegister;
import org.geminicraft.betterwitch.witches.model.CustomWitchBuilder;
import org.geminicraft.betterwitch.witches.model.GoalsInterface;
import org.geminicraft.betterwitch.witches.model.NewTestWitch;
import org.mineacademy.fo.Common;

import java.util.Objects;

@AIGoalsAnnotation(name = "followPlayer", description = "Follow the player around")
public class FollowPlayerGoal implements GoalsInterface {

    private int speed;
    private float distance;
    NewTestWitch entityInsentient;
    String test;
    CustomWitchBuilder builder = new CustomWitchBuilder(Objects.requireNonNull(WitchRegister.fetchNames()));


    @Getter
    private final int availableArgs = 2;

    public FollowPlayerGoal(NewTestWitch entityInsentient, ParamsFileHandler fileHandler) {
        this.entityInsentient = entityInsentient;


        speed = fileHandler.getKeyInteger("speed", 8);
        Common.log(speed + " this is the speed value");

        distance = fileHandler.getKeyFloat("distance", 10);
        Common.log(distance + " distance value");

        test = fileHandler.getKeyString("test");


        Common.log(builder.getName() + " name test");
        Common.log(builder.getFileString("Name"));
        Common.log(builder.getFileStringList("GoalSelectors"));

        Common.log(test + " Hey, I am the test!");
//
//        entityInsentient.setPosition(entityInsentient.getLocationGlobal().getX(), entityInsentient.getLocationGlobal().getY(), entityInsentient.getLocationGlobal().getZ());
//        entityInsentient.setGoalTarget(((CraftPlayer) Bukkit.getPlayer("Ares_Xena")).getHandle(), EntityTargetEvent.TargetReason.CUSTOM, true);


    }


    @Override
    public PathfinderGoal create() {
        return new PathfinderGoalTest(entityInsentient, speed, distance);

    }
}
