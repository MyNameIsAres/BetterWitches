package org.geminicraft.betterwitch.cauldron;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.FileUtil;
import org.mineacademy.fo.remain.CompMaterial;
import org.mineacademy.fo.remain.CompMetadata;
import org.mineacademy.fo.settings.YamlSectionConfig;

import java.io.File;
import java.util.*;

/*
    Loop through all files in cauldrons folder
    Check if file has format: <name>-cauldron.yml <-- regex?
    Then get the key.





 */

public class CauldronBase extends YamlSectionConfig implements CauldronBuilder {


    private static List<CauldronBase> cauldronList = new ArrayList<>();

    // TODO: This either replaces or will utilize the cauldron recipe class.
    Map<ItemStack, Integer> cauldronMap = new HashMap<>();

    private ItemStack cauldron; // geter and setters

    private String name;
    private String[] lore;

    public CauldronBase(String name) {
        super(name);
        addCauldrons(this);
        // TODO: externalize this too?
//        if (!(cauldron.getType().equals(CompMaterial.CAULDRON.getMaterial()))) {
//            return;
//        }

        Common.log(name + " This is the name");

        loadConfiguration(null, "cauldrons/" + name + "-cauldron" + (!name.endsWith(".yml") ? ".yml" : ""));

    }


    @Override
    protected void onLoadFinish() {
        Common.log("Using onLoadFinish");
        name = getString("Name");
    }

    /*
        SomeClass.checkFileRegex("contains this", pass in file);
        SomeClass.checkFileRegex("contains this","extension",  pass in file);

     */
    public void fetchCauldronFiles() {
        String regex = "\\w+-cauldron\\.yml";
        String testRegex = "Test-cauldron\\.yml";
        Common.log("Triggered this fucntion");
        for (File file : FileUtil.getFiles("cauldrons", "yml")) {
            if (file.getName().matches(regex)) {

            }

        }
    }


    /*

        Create a list. That list will contain CauldronBase items.
        Each item has a name (for now). When you click on one of them, you get that
        particular cauldron.

     */

    public void addCauldrons(CauldronBase item) {
        final String regex = "\\w+-cauldron\\.yml";
        for (File file : FileUtil.getFiles("cauldrons", "yml")) {
            if (file.getName().matches(regex)) {
                CauldronBase base = new CauldronBase(item.getName());
                cauldronList.add(base);

                Common.log(item + " I am the item");
            }
        }

    }

    public static CauldronBase getCauldrons() {
        for (CauldronBase cauldrons : cauldronList) {
            Common.log("Name: " + cauldrons.getName());
            return cauldrons;
        }
        return null;
    }

    public static Collection<CauldronBase> getCauldronCollection() {
        return cauldronList;
    }


    public void setCauldronNameFile(String name) {
        this.name = name;

        save("Name", name);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setLore(String[] lore) {
        this.lore = lore;
    }

    @Override
    public String[] getLore() {
        return lore;
    }

    @Override
    public void setAllowedItems(ItemStack items) {

    }

    @Override
    public ItemStack getAllowedItems() {
        return null;
    }

    @Override
    public void setCustomItem(ItemStack items) {

    }

    @Override
    public ItemStack getCustomItem() {
        return null;
    }

    @Override
    public void setOrderedCombination(ItemStack items) {

    }

    @Override
    public ItemStack getOrderedCombination(ItemStack items) {
        return null;
    }

    @Override
    public void setUnorderedCombinations(ItemStack items) {

    }

    @Override
    public ItemStack getUnorderedCombinations() {
        return null;
    }


    public void addToCauldronMap(ItemStack item, Integer amount) {
        cauldronMap.put(item, amount);
    }

    public ItemStack getCauldron() {
        CompMetadata.setMetadata(cauldron, "key", "value");
        return cauldron;
    }


}
