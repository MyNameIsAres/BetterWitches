package org.geminicraft.betterwitch.witches.model;

import net.minecraft.server.v1_16_R2.*;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.inventory.ItemStack;
import org.geminicraft.betterwitch.Pathfinders.PathfinderGoalTest;
import org.geminicraft.betterwitch.witches.WitchAbilities;
import org.geminicraft.betterwitch.witches.WitchPotionEffect;

import java.util.ArrayList;
import java.util.List;

public class Witch extends EntityWitch {

    //    private final String name;
    private double health;
    private Integer droppedExp;
    private List<ItemStack> items = new ArrayList<>();
    private List<WitchPotionEffect> potioneffects = new ArrayList<>(); // A list of potion effects
    private List<WitchAbilities> abilities = new ArrayList<>(); // A list of abilities

    public Witch(Location location, Player player) {
        super(EntityTypes.WITCH, ((CraftWorld) location.getWorld()).getHandle());
        this.setPosition(location.getX(), location.getY(), location.getZ());
        this.setGoalTarget(((CraftPlayer) player).getHandle(), EntityTargetEvent.TargetReason.CUSTOM, true);
//        this.name = name;
    }

    @Override
    protected void initPathfinder() {
        this.goalSelector.a(0, new PathfinderGoalFloat(this));
        this.goalSelector.a(1, new PathfinderGoalTest(this, 1, 15));
        this.goalSelector.a(3, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0F));
        this.goalSelector.a(4, new PathfinderGoalRandomLookaround(this));
        super.initPathfinder();

        /* Others to possibly include, probably more version specific:
            - stroll village
            - water jump,
            - target condition
            - melee attack
            - avoid target (when health is low)
            - flying (for some spooky effects)
            - defend village?
            - custom ones list here:
                -
            - HurtByTarget
            - Followntity
            - MoveThroughVillage/MoveTwardsTarget/MoveTowardsRestriction
            - NearestAttackableTargte(Witch)
            - NearestVillage
            - Panic
            - Stroll/land
            - r

         */

    }


}
