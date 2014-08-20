package com.h4.HexiCrates;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * HexiCrates v0.1 rev 0
 * by H4
 * 20082014
 */

public class HexiCrates extends JavaPlugin implements Listener {

    private CratesCore packCore = new CratesCore();
    private PluginConfiguration config = new PluginConfiguration(this);

    @Override
    public void onEnable() {
        getLogger().info("HexiPacks Started.");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        getLogger().info("HexiPacks Closed.");
    }

    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String l, String[] args) {
        int returnCode = 1;

        if (args.length > 0) {
            if (cs instanceof Player) {
                switch (cmd.getName().toLowerCase()) {
                    case "roll":
                        returnCode = packCore.spawnPack((Player)cs); break;
                    case "x":
                        // Placeholder
                    default:
                        // Command doesn't exist
                }
            }
        }

        // Check the return code and decide if we need to print out an error message
        switch (returnCode) {
            case 1:

            case 2:

            case 3:
        }

        if (returnCode == 0) {
            return true;
        }else{
            return false;
        }
    }
}
