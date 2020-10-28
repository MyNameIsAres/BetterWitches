package org.geminicraft.betterwitch.witches.model;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R2.entity.CraftPlayer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityTargetEvent;

public class TestWitch extends Witch {

    public TestWitch(Location location, Player player, String name, EntityType entityType) {
        super(location, player, name, entityType);
        this.setPosition(location.getX(), location.getY(), location.getZ());
        this.setGoalTarget(((CraftPlayer) player).getHandle(), EntityTargetEvent.TargetReason.CUSTOM, true);
    }

    @Override
    protected void initPathfinder() {

        super.initPathfinder();
    }
}
