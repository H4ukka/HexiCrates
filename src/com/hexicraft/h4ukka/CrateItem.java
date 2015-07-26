package com.hexicraft.h4ukka;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

/**
 * Created by H4 on 26.7.2015.
 */
public class CrateItem {

    private double weight;
    private ItemStack item;
    private ItemMeta meta;

    CrateItem(String material, short damage, int amount, double weight) {

        item = new ItemStack(
            Material.matchMaterial(material),
            amount,
            damage
        );

        meta = item.getItemMeta();

        List<String> lore = Arrays.asList(ChatColor.DARK_PURPLE + "a crate item!");

        meta.setLore(lore);
        item.setItemMeta(meta);

        this.weight = weight;
    }

    public ItemStack getItem () { return item; }

    public double getWeight () { return weight; }
}
