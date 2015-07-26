package com.hexicraft.h4ukka;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class CrateTemplate {

    String crateName;

    int itemLimit;
    double totalWeight = 0.0d;

    List<String> itemList;
    List<CrateItem> itemChoices = new ArrayList<>();

    private JavaPlugin plugin;

    private PluginConfiguration config;

    public CrateTemplate (String crateName, int itemLimit, List<String> sourceItems,
                          JavaPlugin plugin, PluginConfiguration config) {

        this.crateName = crateName;
        this.itemLimit = itemLimit;
        this.itemList = sourceItems;
        this.plugin = plugin;
        this.config = config;

        if (config.getBoolean("debugMode"))
            plugin.getLogger().info(
                    "Instancing CrateTemplate "
                    + crateName + " LMT: [" + itemLimit + "] ITM: "
                    + sourceItems.toString()
            );

        parseItems ();
    }

    private void parseItems () {

        for (String i : itemList) {
            // Split
            String[] item = i.split("/");

            // Assign
            itemChoices.add(new CrateItem(item));

            totalWeight += Double.parseDouble(item[3]);
        }
    }

    public Crate generateCrate () {

        return new Crate (crateName, itemLimit, totalWeight, itemChoices, plugin, config);
    }
}
