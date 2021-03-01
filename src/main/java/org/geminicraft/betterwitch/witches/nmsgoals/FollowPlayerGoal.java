package org.geminicraft.betterwitch.witches.nmsgoals;


import net.minecraft.server.v1_16_R2.EntityInsentient;
import net.minecraft.server.v1_16_R2.PathfinderGoal;
import org.geminicraft.betterwitch.AIGoalsAnnotation;
import org.geminicraft.betterwitch.pathfinders.PathfinderGoalTest;
import org.geminicraft.betterwitch.witches.model.GoalsInterface;

//@AIGoalsAnnotation(name = "followPlayer", description = "Follow the player around")
public class FollowPlayerGoal implements GoalsInterface {

    EntityInsentient entityInsentient;

    public FollowPlayerGoal(EntityInsentient entityInsentient) {
        this.entityInsentient = entityInsentient;
    }

    @Override
    public PathfinderGoal create() {
        return new PathfinderGoalTest(entityInsentient, 1, 15);

    }
}
