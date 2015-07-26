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
        }
        p.sendMessage("§aYou Spawned the §e" +  reward.getName() + " §aCrate!");

        return ReturnCode.SUCCESS;
    }

    private void populateStorage () {
        Set<String> crateDefinitions = config.getStringSet("Crates", false);

        for (String crateDefinition : crateDefinitions) {

            if (config.getBoolean("debugMode"))
                plugin.getLogger().info("Instancing crate: " + crateDefinition);

            crateStorage.add(new CrateTemplate(
                crateDefinition,
                config.getInt("Crates." + crateDefinition + ".Reward"),
                config.getList("Crates." + crateDefinition + ".Items"),
                plugin,
                config)
            );
        }
    }
}
