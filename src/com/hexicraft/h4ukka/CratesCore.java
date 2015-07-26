package com.hexicraft.h4ukka;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class CratesCore {

    private final PluginConfiguration config;
    private final JavaPlugin plugin;

    List<CrateTemplate> crateStorage = new ArrayList<>();

    public CratesCore (PluginConfiguration config, JavaPlugin plugin) {
        this.config = config;
        this.plugin = plugin;

        this.populateStorage();
    }

    public ReturnCode spawnCrate (Player p, String crate) {
        Crate reward = crateStorage.get(Integer.parseInt(crate)).generateCrate();

        for (ItemStack item : reward.getContents()) {
            p.getInventory().addItem(item);
            //config.setDefault("test",item);
        }

        p.sendMessage("§aYou Spawned the §e" + reward.getName() + " §aCrate!");

        return ReturnCode.SUCCESS;
    }

    private void populateStorage () {
        Set<String> crateDefinitions = config.getStringSet("Crates", false);

        for (String crateDefinition : crateDefinitions) {

            Set<String> itemDefinitions = config.getStringSet("Crates." + crateDefinition +".Items", false);
            List<CrateItem> items = new ArrayList<>();

            if (config.getBoolean("debugMode"))
                plugin.getLogger().info("Instancing crate: " + crateDefinition);

            for (String itemDefinition : itemDefinitions) {

                if (config.getBoolean("debugMode")) {
                    plugin.getLogger().info("itemDefinition: " + itemDefinition);

                    plugin.getLogger().info("Crates." + crateDefinition + ".Items." + itemDefinition + ".material");
                    plugin.getLogger().info("Crates." + crateDefinition + ".Items." + itemDefinition + ".damage");
                    plugin.getLogger().info("Crates." + crateDefinition + ".Items." + itemDefinition + ".amount");
                    plugin.getLogger().info("Crates." + crateDefinition + ".Items." + itemDefinition + ".weight");

                    plugin.getLogger().info(config.getString("Crates." + crateDefinition + ".Items." + itemDefinition
                            + ".material"));
                    plugin.getLogger().info(config.getString("Crates." + crateDefinition + ".Items." + itemDefinition
                            + ".damage"));
                    plugin.getLogger().info(config.getString("Crates." + crateDefinition + ".Items." + itemDefinition +
                            ".amount"));
                    plugin.getLogger().info(config.getString("Crates." + crateDefinition + ".Items." + itemDefinition
                            + ".weight"));
                }

                items.add(new CrateItem(
                    config.getString("Crates." + crateDefinition + ".Items." + itemDefinition + ".material"),
                    config.getShort("Crates." + crateDefinition + ".Items." + itemDefinition + ".damage"),
                    config.getInt("Crates." + crateDefinition + ".Items." + itemDefinition + ".amount"),
                    config.getDouble("Crates." + crateDefinition + ".Items." + itemDefinition + ".weight")
                    )
                );
            }

            crateStorage.add(new CrateTemplate(
                crateDefinition,
                config.getInt("Crates." + crateDefinition + ".Reward"),
                items,
                plugin,
                config)
            );
        }
    }
}
