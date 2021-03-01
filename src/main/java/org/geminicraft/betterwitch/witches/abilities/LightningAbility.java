package org.geminicraft.betterwitch.witches.abilities;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.util.Vector;
import org.geminicraft.betterwitch.witches.model.Witch;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.MathUtil;
import org.mineacademy.fo.RandomUtil;

public class LightningAbility extends WitchAbilities {

    public LightningAbility() {
        super("Lightning Strike");
    }

    @Override
    public void onWitchDamaged(Witch witch, EntityDamageByEntityEvent event) {
        if (RandomUtil.chance(80) && event.getDamager() instanceof Player) {
            final Player attacker = (Player) event.getDamager();

            attacker.getWorld().strikeLightningEffect(attacker.getLocation());
            attacker.setHealth(MathUtil.range(attacker.getHealth() - 4, 0, 20));

            Common.tell(attacker, "&bYou were struck with lightning!");
        }
    }
}
