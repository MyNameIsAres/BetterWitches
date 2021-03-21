package org.geminicraft.betterwitch.witches;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.geminicraft.betterwitch.witches.model.NewTestWitch;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.FileUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class WitchRegister {

    List<NewTestWitch> witchList = new ArrayList<>();

    @Getter
    private static final WitchRegister instance = new WitchRegister();

    public void loadWitches() {
        for (File file : FileUtil.getFiles("custom-witches", "yml")) {

            Common.log(file.getName() + " this goes fine");
            witchList.add(new NewTestWitch(new Location(Bukkit.getServer().getWorlds().get(0), 0, 0, 0), file.getName()));

            Common.log("Adding does not " + witchList);
        }
    }

    public NewTestWitch getWitchByName(String name) {
        for (NewTestWitch witch : witchList) {
            if (witch.getName().equalsIgnoreCase(name)) {
                return witch;
            }
        }
        return null;
    }
    
    public void testForWitches() {
        for (NewTestWitch witch : witchList) {
            Common.log(witch.getName());
        }
    }

    public static String fetchNames() {
        for (File file : FileUtil.getFiles("custom-witches", "yml")) {
            Common.log(file.getName() + " checking for a file name");
            return file.getName();
        }

        return null;
    }

}
