package com.hexicraft.h4ukka;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Created by H4 on 26.7.2015.
 */
public class CrateItem {

    private double weight;
    private ItemStack item;
    private ItemMeta meta;

    CrateItem(String source[]) {

        item = new ItemStack(
                Material.matchMaterial(source[0]),
                Integer.parseInt(source[2]),
                Short.parseShort(source[1])
        );

        weight = Double.parseDouble(source[3]);
    }

    public ItemStack getItem () { return item; }

    public double getWeight () { return weight; }
}
