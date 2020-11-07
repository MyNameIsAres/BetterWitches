package org.geminicraft.betterwitch.cauldron;

import org.mineacademy.fo.Common;
import org.mineacademy.fo.FileUtil;
import org.mineacademy.fo.remain.CompMaterial;
import org.mineacademy.fo.settings.YamlSectionConfig;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CauldronRegister {

    private List<CauldronBase> cauldronList = new ArrayList<>();

    private CauldronBase base;


//    protected CauldronRegister(CauldronBase base) {
//        super(base.getName());
//
////        loadConfiguration(null, "cauldrons/" + base.getName() + "-cauldron" + (!base.getName().endsWith(".yml") ? ".yml" : ""));
//    }

//    @Override
//    protected void onLoadFinish() {
//        Common.log("Using onLoadFinish");
////         = getString("Name");
//    }

    public CauldronBase fetchCauldrons(CauldronBase item) {
        final String regex = "\\w+-cauldron\\.yml";
        for (File file : FileUtil.getFiles("cauldrons", "yml")) {
            if (file.getName().matches(regex)) {
//                CauldronBase base = new CauldronBase(CompMaterial.CAULDRON.toItem(), item.getName(), item.getLore());
                cauldronList.add(base);
            }

            return item;
        }

        return null;
    }
    

}
