package org.geminicraft.betterwitch.cauldron;

import lombok.Getter;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.FileUtil;
import org.mineacademy.fo.collection.StrictList;


import java.io.File;


public class CauldronRegister {

    @Getter
    private static final CauldronRegister instance = new CauldronRegister();

    @Getter
    final StrictList<CauldronFoundation> cauldronBaseList = new StrictList<>();

    public void addToStrictList(String name) {
        final CauldronFoundation foundation = new CauldronFoundation(name);

        foundation.save();
        cauldronBaseList.add(foundation);
    }

    public CauldronFoundation getCauldron(String name) {
        for (CauldronFoundation loadedCauldrons : cauldronBaseList) {
            if (loadedCauldrons.getName().equals(name)) {
                return loadedCauldrons;
            }
        }
        return null;
    }

    public void getCauldronFoundationList() {
        for (File file : FileUtil.getFiles("cauldrons", "yml")) {
            
            final CauldronFoundation foundation = new CauldronFoundation(file.getName());

            cauldronBaseList.add(foundation);
        }
    }

    // Utility tool for development  - to be moved
    public void getListCount() {
        for (File file : FileUtil.getFiles("cauldrons", "yml")) {
            Common.log(file.getName());
        }
    }

    // Utility tool for development - to be moved
    public void checkTest() {
//        String regex = "\\w+-cauldron\\.yml";
        for (File file : FileUtil.getFiles("cauldrons", "yml")) {
            Common.log(file.getName());
        }
    }
}
