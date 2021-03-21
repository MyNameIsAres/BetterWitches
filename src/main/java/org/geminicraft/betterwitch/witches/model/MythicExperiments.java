package org.geminicraft.betterwitch.witches.model;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import net.minecraft.server.v1_16_R2.*;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R2.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_16_R2.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityTargetEvent;
import org.geminicraft.betterwitch.AIGoalsAnnotation;
import org.geminicraft.betterwitch.pathfinders.PathfinderGoalTest;
import org.geminicraft.betterwitch.reflections.Reflections;
import org.geminicraft.betterwitch.reflections.scanners.SubTypesScanner;
import org.geminicraft.betterwitch.reflections.scanners.TypeAnnotationsScanner;
import org.geminicraft.betterwitch.reflections.util.ClasspathHelper;
import org.geminicraft.betterwitch.reflections.util.ConfigurationBuilder;
import org.mineacademy.fo.Common;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Deprecated
public class MythicExperiments extends Witch {


    public MythicExperiments(String name, Location location, Player player) {
        super(name, location);


        this.setPosition(location.getX(), location.getY(), location.getZ());

        this.setGoalTarget(((CraftPlayer) player).getHandle(), EntityTargetEvent.TargetReason.CUSTOM, true);


    }

    public void sayHello() {
        Common.log("Hello");
    }

    @SneakyThrows
    @Override
    protected void initPathfinder() {
        super.initPathfinder();

//        this.sayHello();
//        Common.log(this.getBukkitEntity() + " entity");
//        this.goalSelector.a(0, new PathfinderGoalTest(this, 1, 15));


//        goalAdder.sayHi();
//        goalAdder.addPathfindersGoal(0, this.getBukkitEntity(), new PathfinderGoalTest(this, 1, 15));
//        goalAdder.addPathfindersGoal(1, this.getBukkitEntity(), new PathfinderGoalFloat(this));

//        goalAdder.addPathfindersGoal(0, this.getBukkitEntity(), new PathfinderGoalTest(this, 1, 15));
//
//        goalAdder.addPathfindersGoal(1, this.getBukkitEntity(), new PathfinderGoalFloat(this));

//        goalAdder.whatthefuckisthegoal(this.getBukkitEntity());


    }

//    public final void spawnWitch(Location location) {
//        Common.log("entering method");
//
//        location.getWorld().spawnEntity(location, EntityType.WITCH);
//
//
//        Common.log("**TEST** Spawned experiment at " + location);
//    }
}


@Deprecated
class CustomGoal implements GoalsInterface {

    @Setter
    @Getter
    String goalAlias = "customGoal";

    EntityInsentient entityInsentient;

    Entity entity;

    Integer speed = 2;

    Integer distance = 2;

    public CustomGoal() {

    }

    public CustomGoal(EntityInsentient entityInsentient, Integer speed, Integer distance) {
        this.entityInsentient = entityInsentient;
        this.speed = speed;
        this.distance = distance;

    }

    @Override
    public PathfinderGoal create() {
        return new PathfinderGoalTest(entityInsentient, speed, distance);

    }

    @Override
    public int availableArguments() {
        return 0;
    }


}



