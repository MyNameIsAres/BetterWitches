package org.geminicraft.betterwitch.witches.abilities;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.util.Vector;
import org.geminicraft.betterwitch.witches.model.Witch;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.MathUtil;
import org.mineacademy.fo.RandomUtil;

public class TestWitchLightning extends WitchAbilities {

    public TestWitchLightning() {
        super("Lightning Strike");
    }

    @Override
    public void onWitchDamaged(Witch witch, EntityDamageByEntityEvent event) {
        if (RandomUtil.chance(100) && event.getDamager() instanceof Player) {
            final Player attacker = (Player) event.getDamager();

            attacker.getWorld().strikeLightningEffect(attacker.getLocation());
            attacker.setHealth(MathUtil.range(attacker.getHealth() - 4, 0, 20));

            Common.tell(attacker, "&bThe boss " + witch.getName() + " has struck you with lightning!!");
        }
    }
}
