package com.h4.HexiCrates;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


public class CratesCore {

    public CratesCore () {
    }

    public int spawnPack (Player player) {
        ItemStack test = new ItemStack(Material.WOOD_HOE, 1);
        player.getInventory().addItem(test);
        return 0;
    }
}
