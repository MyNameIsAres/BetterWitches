package org.geminicraft.betterwitch.commands;

import org.bukkit.material.Cauldron;
import org.geminicraft.betterwitch.cauldron.CauldronBase;
import org.geminicraft.betterwitch.cauldron.CauldronRegister;
import org.geminicraft.betterwitch.cauldron.menu.CauldronSelectMenu;
import org.mineacademy.fo.command.SimpleCommand;

public class MenuCauldronSelect extends SimpleCommand {

    public MenuCauldronSelect() {
        super("gui");
    }

    @Override
    protected void onCommand() {
        checkConsole();

        new CauldronSelectMenu().displayTo(getPlayer());
    }
}
