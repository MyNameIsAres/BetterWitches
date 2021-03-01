package org.geminicraft.betterwitch.witches.nmsgoals;

import lombok.Getter;
import lombok.Setter;
import net.minecraft.server.v1_16_R2.EntityCreature;
import net.minecraft.server.v1_16_R2.PathfinderGoal;
import net.minecraft.server.v1_16_R2.PathfinderGoalMeleeAttack;
import org.bukkit.entity.Entity;
import org.geminicraft.betterwitch.AIGoalsAnnotation;
import org.geminicraft.betterwitch.witches.model.GoalsInterface;

@AIGoalsAnnotation(name = "meleeAttack", description = "A melee attack")
public class MeleeAttackGoal implements GoalsInterface {

    @Setter
    @Getter
    String goalAlias = "meleeAttack";

    @Setter
    @Getter
    Double damage = 1.0D; // Default

    Entity entity;

    public MeleeAttackGoal() {

    }

    public MeleeAttackGoal(Entity entity, Double damage) {
        this.entity = entity;
        this.damage = damage;
    }

    @Override
    public PathfinderGoal create() {
        return new PathfinderGoalMeleeAttack((EntityCreature) entity, damage, true);

    }


}