package org.geminicraft.betterwitch.witches.model;

import lombok.SneakyThrows;
import net.minecraft.server.v1_16_R2.*;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_16_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R2.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_16_R2.entity.CraftWitch;
import org.bukkit.entity.*;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
//import org.geminicraft.betterwitch.pathfinders.*;
import org.geminicraft.betterwitch.AIGoalsAnnotation;
import org.geminicraft.betterwitch.witches.abilities.WitchAbilities;
import org.geminicraft.betterwitch.witches.WitchPotionEffect;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.ReflectionUtil;
import org.mineacademy.fo.Valid;
import org.mineacademy.fo.remain.CompMetadata;
import org.mineacademy.fo.remain.Remain;

import javax.annotation.Nullable;
import java.lang.reflect.Constructor;
import java.util.*;


// TODO: Deprecated class, to be removed in a future version.
@Deprecated
public abstract class Witch extends EntityWitch {


    @AIGoalsAnnotation(name = "test", description = "tester")
    public String test = "sdaf";

    private static final Map<String, Witch> witchNamesMap = new HashMap<>();
    private static final String WITCH_TAG = "TEST";


    private final String name;
    private final EntityType entityType = EntityType.WITCH;
    private double health;
    private Integer droppedExp;
    private List<ItemStack> items = new ArrayList<>();
    private List<WitchPotionEffect> potioneffects = new ArrayList<>(); // A list of potion effects
    private List<WitchAbilities> abilities = new ArrayList<>(); // A list of abilities

    // Constructor can be simplified/cleaned up. Switch to Abstract Factory pattern?
    public Witch(String name, Location location) {
        super(EntityTypes.WITCH, ((CraftWorld) location.getWorld()).getHandle());
        this.name = name;
        witchNamesMap.put(name, this);

    }

    @Override
    protected void initPathfinder() {


        this.goalSelector.a(0, new PathfinderGoalFloat(this));
//        this.goalSelector.a(1, new PathfinderGoalTest(this, 1, 15));
        this.goalSelector.a(3, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0F));
        this.goalSelector.a(4, new PathfinderGoalRandomLookaround(this));

        Common.log(this.goalSelector.toString());

        super.initPathfinder();


    }

    public final String getName() {
        return name;
    }

    public final Double getWitchHealth() {
        return health;
    }


    // -----------------------------------------------------
    // Events called automatically for a given Witch
    // -----------------------------------------------------
    // When the Witch dies

    public void onDeath(@Nullable final Player killer, final Witch witch, final EntityDeathEvent event) {
    }

    // Called when something attacks the Witch
    public void onDamaged(final LivingEntity attacker, final Witch witch, final EntityDamageByEntityEvent event) {
    }

    // Called automatically from Witch timed task
    public void onTick(final Witch witch) {
    }

    // Called automatically after the Witch has been spawned
    protected void onSpawn(final Location location, final Witch witch) {

    }

    public final Integer getDroppedExp() {
        return droppedExp;
    }


    final public void addAbility(WitchAbilities ability) {
        abilities.add(ability);
    }


    public final List<WitchAbilities> getAbilities() {
        return abilities;
    }

    public final void spawnWitch(Location location) {
        Common.log("entering method");

        final LivingEntity entity = (LivingEntity) location.getWorld().spawnEntity(location, entityType);

        Remain.setCustomName(entity, name);
        CompMetadata.setMetadata(entity, WITCH_TAG, name);

        Common.log("**TEST** Spawned witch at " + location);
    }

    // More utilit methods?
    public static Witch findByTag(Entity witch) {


        final String witchName = CompMetadata.getMetadata(witch, "TEST");

        return witchName != null ? findWitchByName(witchName) : null;
    }


    public static Witch findWitch(Entity entity) {
        if (!(entity instanceof CraftWitch)) {
            return null;
        }
        final String witchName = CompMetadata.getMetadata(entity, WITCH_TAG);

        return witchName != null ? findWitchByName(witchName) : null;
    }

    public static Witch findWitchByName(String name) {
        Valid.checkNotNull(name, "The Name is null!");
        for (Witch witch : witchNamesMap.values()) {
            if (witch.getName().equals(name)) {
                return witch;
            }
        }

        return null;
    }

}
