package org.geminicraft.betterwitch.commands;

import org.geminicraft.betterwitch.cauldron.menu.CauldronRecipesMenu;
import org.mineacademy.fo.command.SimpleCommand;

public class MenuRecipeSelect extends SimpleCommand {

    public MenuRecipeSelect() {
        super("recipe");
    }

    @Override
    protected void onCommand() {
        checkConsole();

        new CauldronRecipesMenu().displayTo(getPlayer());
    }
}
