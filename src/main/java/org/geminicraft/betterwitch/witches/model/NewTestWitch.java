package org.geminicraft.betterwitch.witches.model;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import net.citizensnpcs.api.ai.Goal;
import net.minecraft.server.v1_16_R2.EntityLiving;
import net.minecraft.server.v1_16_R2.EntityTypes;
import net.minecraft.server.v1_16_R2.EntityWitch;
import net.minecraft.server.v1_16_R2.PathfinderGoalFloat;
import org.bukkit.Bukkit;
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
import java.util.Objects;

@SuppressWarnings("unchecked cast")
public class NewTestWitch extends EntityWitch {

    @Getter
    String name;


    Double health;
    Integer droppedExp;
    List<?> abilitiesList;

    // TODO: Null checking
    CustomWitchBuilder builder = new CustomWitchBuilder(Objects.requireNonNull(WitchRegister.fetchNames()));
    GoalAdder test = new GoalAdder();

    // TODO: Currently lacks null checking, type checking
    // TODO Eliminate Player and Location from the constructor params if possible.

    public NewTestWitch(Location location, String name, Player player) {
        super(EntityTypes.WITCH, ((CraftWorld) location.getWorld()).getHandle());
        this.setPosition(location.getX(), location.getY(), location.getZ());

        try {

            test.addPathfinderGoals(this, this.builder.getFileStringList("GoalSelectors"));

            Common.log("Do we add it here");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage() + " this one too");
            Common.log(e.getMessage() + " actual error please");
            Common.log("*ERRRORRRR*");
        }

        this.setPosition(location.getX(), location.getY(), location.getZ());
        this.setGoalTarget(((CraftPlayer) player).getHandle(), EntityTargetEvent.TargetReason.CUSTOM, true);

        this.name = this.builder.getFileString("Name");
        this.health = this.builder.getFileDouble("Health");
//        this.droppedExp = this.builder.getFileInteger("DroppedExp");
//        this.abilitiesList = this.builder.getFileList("Abilities");
    }

    public NewTestWitch(Location location, String name) {
        super(EntityTypes.WITCH, ((CraftWorld) location.getWorld()).getHandle());

        try {
//            test.addPathfinderGoals(this, this.builder.getFileStringList("GoalSelectors"));
            Common.log("Do we add it here");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage() + " this one too");
            Common.log(e.getMessage() + " actual error please");
            Common.log("*ERRRORRRR*");
        }


//        this.setGoalTarget(((CraftPlayer) Objects.requireNonNull(Bukkit.getPlayer("Ares_Xena"))).getHandle(), EntityTargetEvent.TargetReason.CUSTOM, true);
        this.name = this.builder.getFileString("Name");
        this.health = this.builder.getFileDouble("Health");
//        this.droppedExp = this.builder.getFileInteger("DroppedExp");
//        this.abilitiesList = this.builder.getFileList("Abilities");
    }

//
//    @Override
//    protected void initPathfinder() {
//        super.initPathfinder();
//    }

    public final void spawnWitch(Location location) {
        final LivingEntity entity = (LivingEntity) location.getWorld().spawnEntity(location, EntityType.WITCH);

        Remain.setCustomName(entity, name);

        // Method only applicable for testing
        Common.log("**TEST** Spawned witch at " + location);
    }
}
