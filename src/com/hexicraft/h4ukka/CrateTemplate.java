package com.hexicraft.h4ukka;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class CrateTemplate {

    String crateName;

    int itemLimit;
    double totalWeight = 0.0d;

    List<CrateItem> items = new ArrayList<>();

    private JavaPlugin plugin;

    private PluginConfiguration config;

    public CrateTemplate (String crateName, int itemLimit, List<CrateItem> items,
                          JavaPlugin plugin, PluginConfiguration config) {

        this.crateName = crateName;
        this.itemLimit = itemLimit;
        this.items = items;
        this.plugin = plugin;
        this.config = config;

//        if (config.getBoolean("debugMode"))
//            plugin.getLogger().info(
//                "Instancing CrateTemplate "
//                + crateName + " LMT: [" + itemLimit + "] ITM: "
//                + sourceItems.toString()
//            );

        parseItems ();
    }

    private void parseItems () {

        for (CrateItem i : items) {

            totalWeight += i.getWeight();
        }
    }

    public Crate generateCrate () {

        return new Crate (crateName, itemLimit, totalWeight, items, plugin, config);
    }
}
