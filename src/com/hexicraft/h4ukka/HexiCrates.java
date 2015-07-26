package com.hexicraft.h4ukka;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * HexiCrates v0.1 rev 0
 * by H4
 */

public class HexiCrates extends JavaPlugin implements Listener {

    private PluginConfiguration config = new PluginConfiguration(this);
    private CratesCore packCore = new CratesCore(config, this);

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("HexiCrates Started.");
    }

    @Override
    public void onDisable() {
        getLogger().info("HexiCrates Closed.");
    }

    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String l, String[] args) {

        ReturnCode code = ReturnCode.UNSUPPORTED_SOURCE;

        if (args.length > 0) {
            if (cs instanceof Player) {
                switch (cmd.getName().toLowerCase()) {
                    case "roll":
                        code = packCore.spawnCrate((Player) cs, args[0]);
                        break;
                    case "x":
                        // Placeholder
                    default:
                        code = ReturnCode.UNKNOWN_COMMAND;
                }
            }
        } else {
            code = ReturnCode.TOO_FEW_ARGUMENTS;
        }

        if (code.isError) {
            // Error
            cs.sendMessage("§c" + code.errorDescription);
            return false;
        } else {
            // Success!
            return true;
        }
    }
}
