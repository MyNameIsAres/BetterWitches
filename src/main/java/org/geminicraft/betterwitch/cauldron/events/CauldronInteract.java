package org.geminicraft.betterwitch.cauldron.events;

import net.minecraft.server.v1_16_R2.DataWatcher;
import net.minecraft.server.v1_16_R2.EntityItem;
import net.minecraft.server.v1_16_R2.PacketPlayOutEntityMetadata;
import net.minecraft.server.v1_16_R2.PacketPlayOutSpawnEntity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_16_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R2.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_16_R2.inventory.CraftItemStack;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.geminicraft.betterwitch.BetterWitchPlugin;
import org.geminicraft.betterwitch.cauldron.*;
import org.geminicraft.betterwitch.cauldron.menu.CauldronRecipesMenu;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.remain.CompMaterial;

import java.util.*;


public class CauldronInteract implements Listener {


    CauldronRegister register = CauldronRegister.getInstance();
    public CauldronRecipesMenu menu = new CauldronRecipesMenu();
    public CauldronStorage storage;
    public BetterWitchPlugin plugin;
    CauldronCache cache = new CauldronCache();

    public CauldronInteract(BetterWitchPlugin plugin, CauldronStorage storage, CauldronCache cache) {
        this.plugin = plugin;
        this.storage = storage;

    }

    @EventHandler
    public void onThrow(PlayerDropItemEvent event) {
//        event.setCancelled(true);

//        Item item = event.getItemDrop();

        Common.log("Threw item");

        Player player = event.getPlayer();
        double x = player.getLocation().getX();
        double y = player.getLocation().getY();
        double z = player.getLocation().getZ();

//        PacketPlayOutSpawnEntity packet = new PacketPlayOutSpawnEntity();

        ItemStack item = new ItemStack(Material.DIAMOND);

//
//        EntityItem spawned = new EntityItem(((CraftWorld) player.getWorld()).getHandle(), x, y, z);
//        DataWatcher watcher = new DataWatcher(spawned);
//        spawned.setLocation(player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ(), 0, 0);
//        spawned.setItemStack(CraftItemStack.poasNMSCopy(item));
//        PacketPlayOutSpawnEntity packet_item = new PacketPlayOutSpawnEntity(spawned, 2);
//        PacketPlayOutEntityMetadata data = new PacketPlayOutEntityMetadata(spawned.getId(), spawned.getDataWatcher(), true);
//
//        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet_item);
//
//
//        Common.log(packet_item.toString() + " Test item");
//        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(data);


//        spawned.get


    }

    public static String getStringLocation(final Location location) {
        return location.getWorld().getName() + "\\" + location.getBlockX() + "\\" + location.getBlockY() + "\\" + location.getBlockZ();
    }


    @EventHandler
    public void onCauldronPlace(BlockPlaceEvent event) {
        final Block block = event.getBlock();

        final ItemStack item = event.getPlayer().getInventory().getItemInMainHand();

        final String cauldronName = item.getItemMeta().getDisplayName().replaceAll("§\\d", "");

        CauldronFoundation test = register.getCauldron(cauldronName);

        test.setName("Bob");

        try {
            storage.getStringLocationMap().put(getStringLocation(block.getLocation()), test.getName());
        } catch (NullPointerException exception) {
            return;
        }

        if (event.getBlock().getType().equals(CompMaterial.CAULDRON.getMaterial())) {
            ArmorStand armorstand = (ArmorStand) event.getBlock().getLocation().getWorld()
                    .spawnEntity(event.getBlock().getLocation().add(0.5D, -0.8D, 0.5D), EntityType.ARMOR_STAND);


            armorstand.setArms(false);
            armorstand.setGravity(false);
            armorstand.setSmall(false);
            armorstand.setVisible(false);
            armorstand.setCustomName(Common.colorize("&4" + test.getName()));
            armorstand.setCustomNameVisible(true);
            armorstand.setCanPickupItems(false);

        }

    }

    @EventHandler
    public void onCauldronBreak(final BlockBreakEvent event) {
        final Block block = event.getBlock();

        if (block.getType().equals(Material.CAULDRON) && storage.getStringLocationMap().containsKey(getStringLocation(block.getLocation()))) {

            event.setDropItems(false);

            Collection<Entity> entityCollection = block.getLocation().getWorld().getNearbyEntities(block.getLocation(), 1.0, 1.0, 1.0);

            entityCollection.forEach((entity) -> {
                if (entity.getType() == EntityType.ARMOR_STAND) {
                    String entityCustomName = entity.getCustomName().replaceAll("§\\d", "");
                    CauldronFoundation foundation = register.getCauldron(entityCustomName);

                    foundation.setMaterial(CompMaterial.fromMaterial(block.getType()));

                    ItemStack itemStack = new ItemStack(foundation.getMaterial().toItem());
                    ItemMeta itemMeta = itemStack.getItemMeta();
                    itemMeta.setDisplayName(Common.colorize("&4" + foundation.getName()));
                    itemStack.setItemMeta(itemMeta);

                    entity.remove();

                    Item item = block.getWorld().dropItemNaturally(block.getLocation(), itemStack);
                    item.setCustomName(itemMeta.getDisplayName());
                    item.setCustomNameVisible(true);
                }
            });
        }
    }

    @EventHandler
    public void onCauldronInteractGUI(final PlayerInteractEvent event) {

        final Player player = event.getPlayer();
        final Block block = event.getClickedBlock();
        final Action action = event.getAction();
        final ItemStack item = player.getInventory().getItemInMainHand();
        final int itemCount = item.getAmount();

        // TODO: Externalize the validation to their own private methods.
        try {
            if (action == Action.RIGHT_CLICK_BLOCK && block.getType() == CompMaterial.CAULDRON.getMaterial()
                    && event.getHand() == EquipmentSlot.HAND
                    && !menu.hasClicked
                    && storage.getStringLocationMap().containsKey(getStringLocation(block.getLocation()))) {

                menu.displayTo(player);

                if (menu.getCauldronCache().getClickedItem() != null) {
                    Common.log(menu.getCauldronCache().getClickedItem().getName() + " test");

                } else {
                    Common.log(menu.getCauldronCache().toString() + " Cauldron cache");
                }

                Common.log(cache.getTestItem() + " this is the test item");
                Common.log(menu.getCauldronCache().toString());
                Common.log(menu.getCauldronCache().getClickedItem().getName());
            } else if (action == Action.LEFT_CLICK_BLOCK) {
                return;
            }
        } catch (NullPointerException exception) {
//            Common.log("Null was thrown!");
        }
    }

    @EventHandler
    public void onCauldronInteract(PlayerInteractEvent event) {
        final Player player = event.getPlayer();
        final Block block = event.getClickedBlock();
        final Action action = event.getAction();
        final ItemStack item = player.getInventory().getItemInMainHand();

        try {
            if (action == Action.RIGHT_CLICK_BLOCK && block.getType() == CompMaterial.CAULDRON.getMaterial()
                    && event.getHand() == EquipmentSlot.HAND
                    && menu.hasClicked
                    && player.getInventory().getItemInMainHand() != null || player.getInventory().getItemInMainHand().getType() != Material.AIR
                    && storage.getStringLocationMap().containsKey(getStringLocation(block.getLocation()))) {

                CustomItem itemPrefixField = menu.getCauldronCache().getClickedItem();

                CustomItem customItem = CustomItem.findCustomItem(new CustomItem(itemPrefixField.getName(), itemPrefixField.getLore(), itemPrefixField.getMaterial()));

                Map<String, Object> tempMap = customItem.getRecipeMap();

                Map<ItemStack, Integer> newTempMap = new HashMap<>();

                for (Map.Entry<String, Object> entry : tempMap.entrySet()) {
                    int amount = (Integer) entry.getValue();
                    Material material = Material.matchMaterial(entry.getKey());

                    ItemStack stack = new ItemStack(material, amount);
                    stack.setAmount(1); // TODO: Experimental optional unit

                    newTempMap.put(stack, amount);

                }

                if (cache.getMap() != null) {
                    if (!item.getType().isAir())
                        if (cache.getMap().containsKey(item)) {
                            cache.getMap().put(item, cache.getMap().get(item) + 1);
                        } else {
                            cache.getMap().put(item, 1);
                        }

                    if (cache.getMap().equals(newTempMap)) {
                        player.getInventory().addItem(customItem.getMaterial().toItem());
                        menu.hasClicked = false;
                    } else {
                        Common.log("NewTempmap map: " + newTempMap.toString());
                        Common.log("This map: " + cache.getMap().toString());
                    }
                }

            }
        } catch (NullPointerException exception) {
//            Common.log("Null was thrown!");
        }
    }

}
