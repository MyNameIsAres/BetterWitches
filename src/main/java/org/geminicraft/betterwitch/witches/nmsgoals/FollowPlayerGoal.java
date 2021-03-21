package org.geminicraft.betterwitch.witches.nmsgoals;


import lombok.Getter;
import net.minecraft.server.v1_16_R2.EntityInsentient;
import net.minecraft.server.v1_16_R2.PathfinderGoal;
import org.apache.commons.lang.StringUtils;
import org.geminicraft.betterwitch.AIGoalsAnnotation;
import org.geminicraft.betterwitch.ParamsFileHandler;
import org.geminicraft.betterwitch.pathfinders.PathfinderGoalTest;
import org.geminicraft.betterwitch.witches.WitchRegister;
import org.geminicraft.betterwitch.witches.model.CustomWitchBuilder;
import org.geminicraft.betterwitch.witches.model.GoalsInterface;
import org.mineacademy.fo.Common;

import java.util.Objects;

@AIGoalsAnnotation(name = "followPlayer", description = "Follow the player around")
public class FollowPlayerGoal implements GoalsInterface {

    private int speed;
    private float distance;
    EntityInsentient entityInsentient;
    String test;
    CustomWitchBuilder builder = new CustomWitchBuilder(Objects.requireNonNull(WitchRegister.fetchNames()));


    @Getter
    private final int availableArgs = 2;

    public FollowPlayerGoal(EntityInsentient entityInsentient, ParamsFileHandler fileHandler) {
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
        

    }


    @Override
    public PathfinderGoal create() {
        return new PathfinderGoalTest(entityInsentient, speed, distance);

    }
}
