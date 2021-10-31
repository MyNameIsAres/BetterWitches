package org.geminicraft.betterwitch.witches;

import lombok.Getter;
import lombok.Setter;
import org.geminicraft.betterwitch.witches.model.NewTestWitch;

import java.util.UUID;

public class ActiveWitchTest {

    @Getter
    @Setter
    private UUID uuid;

    @Getter
    @Setter
    private NewTestWitch witch;


    public ActiveWitchTest(UUID uuid) {
        this.uuid = uuid;
        
    }




    /*

        What I want:

        A mob that can dynamically change targets based on a threat table.
        Passive mobs can become defensive or aggressive
        Modes/States: passive, defensive, aggressive

        Aggressive mobs can become passive or defensive
        Defensive mobs can become aggressive or passive
        Passive mobs can become aggressive or defensive.

        A witch should dynamically be able to follow a person around, go to a
        location, and switch to a different mode/state/target/priority
        on the fly.

        To elaborate with an example:
        Mob 1 might be following a player.
        Mob 2 might be attacking a player.

        When I restart the server I want both Mob 1 and Mob 2 to continue with their respective activities (following and attacking).

     */


}
