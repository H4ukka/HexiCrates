package com.h4.HexiCrates;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;


public class CratesCore {

    private PluginConfiguration config;
    private final JavaPlugin plugin;

    public CratesCore (PluginConfiguration config, JavaPlugin plugin) {
        this.config = config;
        this.plugin = plugin;
    }

    public ReturnCode spawnPack (Player p) {

        /**
         * ItemData structure: [0] = Material name, [1] = Damage value, [2] = Amount, [3] = NBT Data (TBI)
         */

        // List containing all items of the selected pack tier
        List crate = config.getList("SamplePack.Items");

        // Grab
        String item = (String) crate.get(0);

        // Split
        String[] itemData = item.split(":");

        try {
            ItemStack reward = new ItemStack(Material.matchMaterial(itemData[0]), Integer.parseInt(itemData[2]), Short.parseShort(itemData[1]));
            p.getInventory().addItem(reward);
        }catch (NumberFormatException e2) {
            plugin.getLogger().warning("Could not convert data from config! ~spawnPack\n" + e2.getMessage());
            return ReturnCode.PACK_ERROR;
        }

        return ReturnCode.SUCCESS;
    }
}
