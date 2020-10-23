package org.geminicraft.betterwitch.Pathfinders;

import net.minecraft.server.v1_16_R2.*;
import org.mineacademy.fo.Common;

import java.util.EnumSet;

public class PathfinderGoalTest extends PathfinderGoal {

    private final EntityInsentient testWitch;
    private EntityLiving player;

    private final double speed;
    private final double distanceOwnerAndCreature;

    private double x;
    private double y;
    private double z;

    public PathfinderGoalTest(EntityInsentient testWitch, double speed, float distanceOwnerAndCreature) {
        Common.log("Testing custom goal");
        this.testWitch = testWitch;
        this.speed = speed;
        this.distanceOwnerAndCreature = distanceOwnerAndCreature;
        this.a(EnumSet.of(Type.MOVE));

    }


    @Override
    public boolean a() {
        Common.log("Entering A..");
        // Will start the pathfinding goal if it is true
        // Runs every tick (0.05 seconds)


        this.player = this.testWitch.getGoalTarget();
//        Common.log(this.player.toString());
        if (this.player == null) {
            Common.log("Is player null");
            return false;
        } else if (this.testWitch.getDisplayName() == null) {
            Common.log("THis one?");
            return false;
        } else if (!(this.testWitch.getDisplayName().toString().contains(this.player.getName()))) {
//            Common.log("Thiiiiis one");
            return false;
        } else if (this.player.h(this.testWitch) > (double) (this.distanceOwnerAndCreature) * (this.distanceOwnerAndCreature)) {

            // if the distance from the pet to the player is greater than whatever we set in distanceownerandcreature,
            // let's go ahead and set to false. we do not want the witch to fllow us.
            testWitch.setPosition(this.player.locX(), this.player.locY(), this.player.locZ());

            Common.log("Which one fucking is it");
            return false;
        } else {
            // follow the owner

            Vec3D vec = RandomPositionGenerator.a((EntityCreature) this.testWitch, 16,
                    7, this.player.getPositionVector());

            // If it is in air.
            if (vec == null) {
                return false;
            }

            this.x = this.player.locX();
            this.y = this.player.locY();
            this.z = this.player.locZ();

            Common.log("Is this called?");

            return true; // <-- it runs c
        }
    }

    // a() is going to run every tick until it is true
    // once it is true it is going to run c(), only once.
    // it is going to run c(), so long as b() is true
    public void c() {
        Common.log("Entering C..");

        // runner (or bukkit runnable)
        this.testWitch.getNavigation().a(this.x, this.y, this.z, this.speed);
    }


    public boolean b() {
        Common.log("Entering B..");

        // this runs after c()
        // runs every tick as long as its true


        // did I not make it to the location AND am I still within the right distance
        // so long as I did not make to the correct location, and I am still within
        // the right distance, it will return true
        return !this.testWitch.getNavigation().m() && this.player.h(this.testWitch) <
                (double) (this.distanceOwnerAndCreature * this.distanceOwnerAndCreature);

    }

    public void d() {
        Common.log("Is this ever run");
        // runs when b() returns false
        this.player = null;
    }
}
