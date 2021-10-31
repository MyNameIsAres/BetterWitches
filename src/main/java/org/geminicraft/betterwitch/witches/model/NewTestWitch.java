package org.geminicraft.betterwitch.witches.model;

import lombok.Getter;
import lombok.Setter;
import net.minecraft.server.v1_16_R2.EntityTypes;
import net.minecraft.server.v1_16_R2.EntityWitch;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R2.entity.CraftPlayer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityTargetEvent;
import org.geminicraft.betterwitch.witches.ActiveWitchTest;
import org.geminicraft.betterwitch.witches.WitchRegister;
import org.geminicraft.betterwitch.witches.nmsgoals.GoalAdder;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.remain.Remain;

import java.util.List;
import java.util.Objects;

@SuppressWarnings("unchecked cast")
public class NewTestWitch extends EntityWitch {

    // TODO Proper type getters/setters
    @Getter
    String name;
    Double health;
    Integer droppedExp;
    List<?> abilitiesList;

    @Getter
    @Setter
    Location locationGlobal;


    // TODO: Null checking
    CustomWitchBuilder builder = new CustomWitchBuilder(Objects.requireNonNull(WitchRegister.fetchNames()));
    GoalAdder test = new GoalAdder();

    @Override
    protected void initPathfinder() {
//        this.goalSelector.a(0, new PathfinderGoalR);
    }

    // TODO: Currently lacks null checking, type checking
    // TODO Eliminate Player and Location from the constructor params if possible.
    public NewTestWitch(Location location, String name) {
        super(EntityTypes.WITCH, ((CraftWorld) location.getWorld()).getHandle());
        this.setPosition(location.getX(), location.getY(), location.getZ());

        Common.log("HALLO");

//        setLocationGlobal(location);


        try {

            test.addPathfinderGoals(this, this.builder.getFileStringList("GoalSelectors"));

            Common.log("Do we add it here");
        } catch (Exception e) {
            e.printStackTrace();

            Common.log(e.getMessage() + " actual error please");
            Common.log("*ERRRORRRR*");
        }

        // TODO: This should be moved to the pathfindergoal itself
//        this.setPosition(location.getX(), location.getY(), location.getZ());
//        this.setGoalTarget(((CraftPlayer) player).getHandle(), EntityTargetEvent.TargetReason.CUSTOM, true);

        this.name = this.builder.getFileString("Name");
        this.health = this.builder.getFileDouble("Health");
//        this.droppedExp = this.builder.getFileInteger("DroppedExp");
//        this.abilitiesList = this.builder.getFileList("Abilities");
    }


//    // TODO: Remove this in favor of noted refactor
//    public NewTestWitch(Location location, String name) {
//        super(EntityTypes.WITCH, ((CraftWorld) location.getWorld()).getHandle());
//
//        try {
//            test.addPathfinderGoals(this, this.builder.getFileStringList("GoalSelectors"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//        this.setGoalTarget(((CraftPlayer) Objects.requireNonNull(Bukkit.getPlayer("Ares_Xena"))).getHandle(), EntityTargetEvent.TargetReason.CUSTOM, true);
//        this.name = this.builder.getFileString("Name");
//        this.health = this.builder.getFileDouble("Health");
//        this.droppedExp = this.builder.getFileInteger("DroppedExp");
//        this.abilitiesList = this.builder.getFileList("Abilities");
//    }

    public final void spawnCreature(Location location) {
        location.getWorld().spawnEntity(location, EntityType.ZOMBIFIED_PIGLIN);
    }

    // TODO Refactor to create controlled spawning
    public final void spawnWitch(Location location) {
        final LivingEntity entity = (LivingEntity) location.getWorld().spawnEntity(location, EntityType.WITCH);

//        location.getWorld().spawnEntity(location, EntityType.SKELETON);

        Remain.setCustomName(entity, name);

        // Method only applicable for testing
        Common.log("**TEST** Spawned witch at " + location);
    }
}
