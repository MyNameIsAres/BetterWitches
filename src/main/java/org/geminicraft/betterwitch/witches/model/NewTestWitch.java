package org.geminicraft.betterwitch.witches.model;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import net.citizensnpcs.api.ai.Goal;
import net.minecraft.server.v1_16_R2.EntityLiving;
import net.minecraft.server.v1_16_R2.EntityTypes;
import net.minecraft.server.v1_16_R2.EntityWitch;
import net.minecraft.server.v1_16_R2.PathfinderGoalFloat;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R2.entity.CraftPlayer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityTargetEvent;
import org.geminicraft.betterwitch.pathfinders.PathfinderGoalTest;
import org.geminicraft.betterwitch.witches.WitchRegister;
import org.geminicraft.betterwitch.witches.nmsgoals.GoalAdder;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.remain.Remain;

import java.util.List;

@SuppressWarnings("unchecked cast")
public class NewTestWitch extends EntityWitch {

    String name;
    Double health;
    Integer droppedExp;
    List<?> abilitiesList;

    // TODO: Null checking
    CustomWitchBuilder builder = new CustomWitchBuilder(WitchRegister.fetchNames());
    GoalAdder test = new GoalAdder();

    // TODO: Currently lacks null checking, type checking
    public NewTestWitch(Location location, Player player) {
        super(EntityTypes.WITCH, ((CraftWorld) location.getWorld()).getHandle());

        try {
            test.addPathfinderGoals(this, this.builder.getFileStringList("GoalSelectors"));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage() + " this one too");
            Common.log(e.getMessage() + " actual error please");
            Common.log("*ERRRORRRR*");
        }

        this.setPosition(location.getX(), location.getY(), location.getZ());
        this.setGoalTarget(((CraftPlayer) player).getHandle(), EntityTargetEvent.TargetReason.CUSTOM, true);
//        this.name = this.builder.getFileString("Name");
//        this.health = this.builder.getFileDouble("Health");
//        this.droppedExp = this.builder.getFileInteger("DroppedExp");
//        this.abilitiesList = this.builder.getFileList("Abilities");
    }


    @Override
    protected void initPathfinder() {
        super.initPathfinder();
    }

    public final void spawnWitch(Location location) {
        final LivingEntity entity = (LivingEntity) location.getWorld().spawnEntity(location, EntityType.WITCH);

        Remain.setCustomName(entity, name);

        // Method only applicable for testing
        Common.log("**TEST** Spawned witch at " + location);
    }
}
