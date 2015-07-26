package com.hexicraft.h4ukka;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Crate {

    String crateName;
    int itemLimit;
    double totalWeight;

    List<CrateItem> items = new ArrayList<>();
    List<ItemStack> crateContents = new ArrayList<>();

    private JavaPlugin plugin;

    private PluginConfiguration config;

    public Crate (String crateName, int itemLimit, double totalWeight, List<CrateItem> items,
                  JavaPlugin plugin, PluginConfiguration config) {

        this.crateName = crateName;
        this.itemLimit = itemLimit;
        this.items = items;
        this.plugin = plugin;
        this.config = config;
        this.totalWeight = totalWeight;

        fillCrate();
    }

    private void fillCrate () {

        boolean debug = config.getBoolean("debugMode");

        for (int i = 0; i < itemLimit; i++) {

            // Generate
            int randomIndex = -1;
            double random = Math.random() * totalWeight;

            try {
                // Select random item
                for (int j = 0; j < items.size(); j++) {
                    random -= items.get(j).getWeight();
                    if (random <= 0.0d) {
                        randomIndex = j;
                        break;
                    }
                }

//                if (debug)
//                    plugin.getLogger().info(
//                        "Filling crate " + crateName
//                        + " with: " + "MAT: [" + items.get(randomIndex)[0] + "] "
//                        + "DMG: [" + items.get(randomIndex)[1] + "] " + "AMT: ["
//                        + items.get(randomIndex)[2] + "]"
//                    );

                // Construct Material and Append

//                ItemStack contents = new ItemStack(
//                        Material.matchMaterial(items.get(randomIndex)[0]),
//                        Integer.parseInt(items.get(randomIndex)[2]),
//                        Short.parseShort(items.get(randomIndex)[1])
//                );
//
//                ItemMeta meta = contents.getItemMeta();
//
//                List<String> lore = Arrays.asList(ChatColor.DARK_PURPLE + "a crate item!");
//
//                meta.setLore(lore);
//
//                contents.setItemMeta(meta);

                crateContents.add(items.get(randomIndex).getItem());

                if (debug)
                    plugin.getLogger().info("Fill State: [" + i + "/" + itemLimit+ "]");

            }catch (NumberFormatException e2) {
                plugin.getLogger().warning("Error while instancing " + crateName + "!\n" + e2.getMessage());
            }
        }
    }

    public List<ItemStack> getContents () {
        return crateContents;
    }

    public String getName () {
        return crateName;
    }
}
