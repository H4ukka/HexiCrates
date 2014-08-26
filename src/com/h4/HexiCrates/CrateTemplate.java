package com.h4.HexiCrates;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class CrateTemplate {

    String crateName;

    int itemLimit;
    double totalWeight = 0.0d;

    List sourceItems;
    List<String[]> parsedItems = new ArrayList<>();

    private JavaPlugin plugin;

    private PluginConfiguration config;

    public CrateTemplate (String crateName, int itemLimit, List sourceItems, JavaPlugin plugin, PluginConfiguration config) {
        this.crateName = crateName;
        this.itemLimit = itemLimit;
        this.sourceItems = sourceItems;
        this.plugin = plugin;
        this.config = config;

        if (config.getBoolean("debugMode"))
            plugin.getLogger().info("Instancing CrateTemplate " + crateName + " LMT: [" + itemLimit + "] ITM: " + sourceItems.toString());

        parseItems ();
    }

    private void parseItems () {

        for (int i = 0; i < sourceItems.size(); i++) {
            // Split
            String[] item = ((String) sourceItems.get(i)).split(":");

            // Assign
            parsedItems.add(item);

            totalWeight += Double.parseDouble(item[3]);
        }
    }

    public Crate generateCrate () {
        return new Crate (crateName, itemLimit, totalWeight, parsedItems, plugin, config);
    }
}
