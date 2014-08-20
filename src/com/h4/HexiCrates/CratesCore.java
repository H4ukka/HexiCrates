package com.h4.HexiCrates;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


public class CratesCore {

    public CratesCore () {
    }

    public ReturnCode spawnPack (Player p) {
        ItemStack test = new ItemStack(Material.WOOD_HOE, 1);
        p.getInventory().addItem(test);
        return ReturnCode.SUCCESS;
    }
}
