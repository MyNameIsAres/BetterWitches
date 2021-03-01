package org.geminicraft.betterwitch.witches;

import org.bukkit.Location;
import org.geminicraft.betterwitch.witches.model.NewTestWitch;
import org.mineacademy.fo.FileUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class WitchRegister {

    List<NewTestWitch> witchList = new ArrayList<>();

    public void loadWitches() {
        for (File file : FileUtil.getFiles("custom-witches", "yml")) {
//            witchList.add(new NewTestWitch(new Location(null, 0, 0, 0)));
        }
    }

    public static String fetchNames() {
        for (File file : FileUtil.getFiles("custom-witches", "yml")) {

            return file.getName();
        }

        return null;
    }

}
