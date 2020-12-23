package org.geminicraft.betterwitch.witches.events;

import org.bukkit.craftbukkit.v1_16_R2.entity.CraftWitch;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.geminicraft.betterwitch.witches.abilities.WitchAbilities;
import org.geminicraft.betterwitch.witches.model.Witch;
import org.mineacademy.fo.Common;

public class WitchListener implements Listener {

    @EventHandler
    public void onWitchDeath(final EntityDeathEvent event) {
        final Witch witch = findWitch(event.getEntity());

        if (witch != null) {
            Common.log("Witch died");
        }

    }

    @EventHandler
    public void onWitchDamaged(final EntityDamageByEntityEvent event) {
        final Entity damager = event.getDamager();
        final Entity victim = event.getEntity();

        if (!(damager instanceof Player) || !(victim instanceof CraftWitch)) {
            return;
        }

        final Witch witch = findWitch(victim);

        // Create Utility: checkNull method for better code practise.
        if (witch != null) {
            Common.log("Is this null?");
            for (WitchAbilities abilities : witch.getAbilities()) {
                if (abilities != null) {

                    Common.log("Ability is " + abilities);
                    abilities.onWitchDamaged(witch, event);
                } else {
                    Common.log("Skill is null");
                }
            }
            witch.onDamaged((LivingEntity) damager, witch, event);
        } else {
            Common.log("Is the witch null");
        }
    }

    private Witch findWitch(Entity entity) {
        return Witch.findWitch(entity);
    }


}
