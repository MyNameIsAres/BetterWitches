package org.geminicraft.betterwitch.witches.abilities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.geminicraft.betterwitch.witches.model.Witch;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class WitchAbilities {

    // The Ability name
    private final String name;

    // When the Witch attacks
    public void onWitchAttack(final Witch witch, final EntityDamageByEntityEvent event) {
    }

    // When witch is attacked/damaged
    public void onWitchDamaged(final Witch witch, final EntityDamageByEntityEvent event) {
    }


}
