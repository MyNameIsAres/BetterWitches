package org.geminicraft.betterwitch.witches.model;


import org.bukkit.Location;

import org.bukkit.craftbukkit.v1_16_R2.entity.CraftPlayer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityTargetEvent;

import org.geminicraft.betterwitch.witches.abilities.LightningAbility;


public class FirstTestWitch extends Witch {

    public FirstTestWitch(Location location, Player player, String name, EntityType type) {
        super(location, player, name, type);
        this.setPosition(location.getX(), location.getY(), location.getZ());
        this.setGoalTarget(((CraftPlayer) player).getHandle(), EntityTargetEvent.TargetReason.CUSTOM, true);
        addAbility(new LightningAbility());

    }

    @Override
    protected void initPathfinder() {
        super.initPathfinder();
    }
}
