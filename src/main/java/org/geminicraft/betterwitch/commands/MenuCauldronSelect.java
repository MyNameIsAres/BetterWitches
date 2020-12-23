package org.geminicraft.betterwitch.commands;

//import org.geminicraft.betterwitch.cauldron.menu.CauldronSelectMenu;
//import org.geminicraft.betterwitch.cauldron.menu.CauldronSelectMenu;

import org.bukkit.entity.Player;
import org.geminicraft.betterwitch.cauldron.menu.CauldronSelectMenu;
import org.mineacademy.fo.command.SimpleCommand;

public class MenuCauldronSelect extends SimpleCommand {

    public MenuCauldronSelect() {
        super("gui");
    }


    @Override
    protected void onCommand() {
        checkConsole();

        Player player = getPlayer();

        new CauldronSelectMenu().displayTo(player);

    }
}
