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
        //ItemStack test = new ItemStack(Material.WOOD_HOE, 1);
        //p.getInventory().addItem(test);

        // testing code - works - not safe
        List crate = config.getList("SamplePack.Items");
        String item = (String) crate.get(0);
        String[] itemData = item.split(":");

        ItemStack reward = new ItemStack(Material.matchMaterial(itemData[0]), Integer.parseInt(itemData[2]));
        p.getInventory().addItem(reward);

        return ReturnCode.SUCCESS;
    }
}
