package org.geminicraft.betterwitch.witches;

import lombok.Data;
import org.bukkit.potion.PotionEffectType;

@Data
public class WitchPotionEffect {

    private final PotionEffectType potionEffectType;
    private final int amplifier;
}
